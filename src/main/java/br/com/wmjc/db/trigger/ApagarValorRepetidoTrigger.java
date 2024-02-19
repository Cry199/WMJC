package br.com.wmjc.db.trigger;

import org.h2.api.Trigger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ApagarValorRepetidoTrigger implements Trigger {

    @Override
    public void init(Connection conn, String schemaName, String triggerName, String tableName, boolean before, int type) throws SQLException {}

    @Override
    public void fire(Connection conn, Object[] oldRow, Object[] newRow) throws SQLException
    {
        String idDoJogo = newRow[2].toString();
        String idUsuario = newRow[1].toString();
        String dataHora = newRow[3].toString();

        LocalDateTime dataHoraLocalDateTime = LocalDateTime.parse(dataHora);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String dataHoraFormatada = dataHoraLocalDateTime.format(formatter);

        String sql = "DELETE FROM HISTORICO_DE_JOGADAS\n" +
                "WHERE ID_JOGADA IN (\n" +
                "    SELECT ID_JOGADA\n" +
                "    FROM HISTORICO_DE_JOGADAS\n" +
                "    WHERE ID_DO_JOGO = ? AND ID_USUARIO = ? AND DATA_HORA < ?\n" +
                "    ORDER BY DATA_HORA DESC\n" +
                "    LIMIT 1\n" +
                ");";

        try (PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setString(1, idDoJogo);
            stmt.setString(2, idUsuario);
            stmt.setString(3, dataHoraFormatada);
            stmt.executeUpdate();
        }
        catch (SQLException e)
        {
            System.out.println("ApagarValorRepetidoTrigger - Erro ao apagar valor repetido: " + e.getMessage());
        }
    }

    @Override
    public void close() throws SQLException {}

    @Override
    public void remove() throws SQLException {}
}