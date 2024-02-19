package br.com.wmjc.db.trigger;

import org.h2.api.Trigger;

import java.sql.Connection;
import java.sql.SQLException;

public class TriggerUserName implements Trigger
{
    @Override
    public void init(Connection conn, String schemaName, String triggerName, String tableName, boolean before, int type) throws SQLException {}

    @Override
    public void fire(Connection conn, Object[] oldRow, Object[] newRow) throws SQLException
    {
        newRow[6] = newRow[1].toString() + newRow[2].toString();
    }

    @Override
    public void close() throws SQLException {}

    @Override
    public void remove() throws SQLException {}
}
