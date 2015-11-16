package br.edu.ifpi.lazaro.dao;

import java.util.List;

public interface GenericDAO<Entity> {
	
	public void inserir(Entity e);
	public void deletar(Entity e);
	public void atualiza(Entity e);
	public Entity consultar(long id);
	public List<Entity> listar();

}
