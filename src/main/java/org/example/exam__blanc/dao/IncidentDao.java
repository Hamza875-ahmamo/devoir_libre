package org.example.exam__blanc.dao;


import org.example.exam__blanc.model.Incident;

import java.util.Set;

public interface IncidentDao {
    void inserer(Incident i);
    void inser(Set<Incident> incidents);
}