package org.example.exam__blanc.dao.impl;


import org.example.exam__blanc.dao.IncidentDao;
import org.example.exam__blanc.model.Incident;
import org.example.exam__blanc.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Set;

public class IncidentDaoImpl implements IncidentDao {
    @Override
    public void inserer(Incident incident) {
        String sql = "INSERT INTO incident (id, time, status, reference) VALUES (?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DatabaseConnection.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setDate(2, incident.getTime());
            stmt.setString(3, incident.getStatus());
            stmt.setString(4, incident.getReference());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error adding incident: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void inser(Set<Incident> incidents) {
        String sql = "INSERT INTO incident ( time, status, reference) VALUES (?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DatabaseConnection.getConnection();
            stmt = conn.prepareStatement(sql);

            for (Incident incident : incidents) {
                stmt.setDate(2, incident.getTime() != null ? new java.sql.Date(incident.getTime().getTime()) : null);
                stmt.setString(3, incident.getStatus());
                stmt.setString(4, incident.getReference());

                // Exécution de l'insertion pour chaque incident
                stmt.addBatch();
            }

            // Exécution de toutes les insertions en une seule fois pour plus d'efficacité
            stmt.executeBatch();

        } catch (SQLException e) {
            System.err.println("Error inserting incidents: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}

