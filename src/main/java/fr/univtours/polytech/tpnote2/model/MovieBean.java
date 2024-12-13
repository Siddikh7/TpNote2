package fr.univtours.polytech.tpnote2.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 * Entity implementation class for Entity: LocationBean
 *
 */
@Entity
@XmlRootElement
public class MovieBean implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private int note;
    
    
    public MovieBean(Integer id, String title, int note) {
        this.id = id;
        this.title = title;
        this.note = note;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }


    public int getNote() {
        return note;
    }


    public void setNote(int note) {
        this.note = note;
    }


    /**
     * Transforme le byte[] contenant les donn�es de l'images en String.
     * 
     * @return La cha�ne de caract�re permettant l'affichage d'une image depuis une
     *         JSP.
     */
    /*@XmlTransient
    public String getBase64Image() {
        if (null != this.picture && !"".equals(this.picture)) {
            return Base64.getEncoder().encodeToString(this.picture);
        } else {
            return "";
        }
    }*/
}
