package controller;

import dao.PersonaImpl;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.Persona;

@Named(value = "personaC")
@SessionScoped
public class PersonaC implements Serializable {

    private Persona persona;
    PersonaImpl dao;
    private List<Persona> lstPersona;

    public PersonaC() {
        persona = new Persona();
        dao = new PersonaImpl();
    }

    public void registrar() throws Exception {
        try {
            dao.guardar(persona);
            listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registrado", "Registrado con éxito"));
        } catch (Exception e) {
            System.out.println("Error en registrar PersonaC/registrar: " + e.getMessage());
        }
    }

    public void modificar() throws Exception {
        try {
            dao.modificar(persona);
            listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Modificado", "Registrado con éxito"));
        } catch (Exception e) {
            System.out.println("Error en modificar PersonaC/modificar: " + e.getMessage());
        }
    }

    public void eliminar(Persona per) throws Exception {
        try {
            per.setEstado("I");
            dao.cambiarEstado(per);
            dao.eliminar(per);
            listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Eliminado", "Eliminado con éxito"));
        } catch (Exception e) {
            System.out.println("Error en eliminar PersonaC/modificar: " + e.getMessage());
        }
    }

    public void listar() throws Exception {
        try {
            lstPersona = dao.listarTodos();
        } catch (Exception e) {
            System.out.println("Error en listar PacienteC/modificar: " + e.getMessage());
        }
    }

    // Getter y Setter
    

//    public Paciente getPacienteSeleccionado() {
//        return pacienteSeleccionado;
//    }
//
//    public void setPacienteSeleccionado(Paciente pacienteSeleccionado) {
//        this.pacienteSeleccionado = pacienteSeleccionado;
//    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public PersonaImpl getDao() {
        return dao;
    }

    public void setDao(PersonaImpl dao) {
        this.dao = dao;
    }

    public List<Persona> getLstPersona() {
        return lstPersona;
    }

    public void setLstPersona(List<Persona> lstPersona) {
        this.lstPersona = lstPersona;
    }
}
