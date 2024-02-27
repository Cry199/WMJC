package br.com.wmjc.db.trigger;

import org.h2.api.Trigger;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AtualizarNomeTableJogoTrigger implements Trigger {

    @Override
    public void init(Connection conn, String schemaName, String triggerName, String tableName, boolean before, int type) throws SQLException {}

    @Override
    public void fire(Connection conn, Object[] oldRow, Object[] newRow) throws SQLException
    {
        if (oldRow == null)
        {
            String nomeDoJogo = newRow[2].toString();
            String idDoUser = newRow[1].toString();
            String id = newRow[0].toString();

            String novoNomeTabela = String.format("NomeDaTablelaDoJogo_%s_%s", idDoUser, id);

            String sql = "UPDATE JOGOS SET NOMEDATABALADOJOGO = ? WHERE ID = ?";

            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, novoNomeTabela);
                stmt.setString(2, id);
                stmt.executeUpdate();
            } catch (SQLException e) {
                System.out.println("AtualizarNomeTableJogoTrigger - Erro ao atualizar nome da tabela: " + e.getMessage());
            }
        }
    }

    @Override
    public void close() throws SQLException {}

    @Override
    public void remove() throws SQLException {}
}

