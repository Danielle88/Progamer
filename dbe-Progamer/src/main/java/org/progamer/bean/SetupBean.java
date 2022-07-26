package org.progamer.bean;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.progamer.dao.SetupDao;
import org.progamer.model.Setup;

//Controller (view <-> dados)

@Named
@RequestScoped
public class SetupBean {
	
	private Setup setup = new Setup();
	
	//CDI
	@Inject //injeção de dependÊcia
	private SetupDao dao;
	
	public String save() {
		System.out.println(this.setup); //imprime na tela (console) o objeto, por isso sobrescrevemos o metodo toString na classe setup
		new SetupDao().create(setup); // insere no banco
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Setup cadastrado com sucesso!"));
		
		return "setups";
	
	}
	
	public List<Setup> getAll(){
		return new SetupDao().listAll();
	}

	public Setup getSetup() {
		return setup;
	}

	public void setSetup(Setup setup) {
		this.setup = setup;
	}
	

}
