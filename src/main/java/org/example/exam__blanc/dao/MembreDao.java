package org.example.exam__blanc.dao;


import org.example.exam__blanc.model.Membre;

import java.util.List;

public interface MembreDao {
    public void insere(Membre m);
    public List<Membre> chargeListmembre();
}
