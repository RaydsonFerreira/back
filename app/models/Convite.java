package models;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;

import java.util.*;

import play.data.validation.Required;
import play.data.validation.Valid;
import play.db.jpa.GenericModel;


@Entity
public class Convite extends GenericModel {
    @Id
    @Column(name = "id_convite")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "fk_id_usuario_Envio",nullable=false)
    public Usuario usuarioEnvio;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "fk_id_usuario_recibo",nullable=false)
    public Usuario usuarioRecibo;

    @Column(name = "status")
    public String status;

    @Column(name = "dt_convite")
    public Date dataDoConvite;

    public Convite(Usuario usuarioEnvio, Usuario usuarioRecibo, String status) {
        this.usuarioEnvio = usuarioEnvio;
        this.usuarioRecibo = usuarioRecibo;
        this.status = status;
        this.dataDoConvite = new Date();
    }
}
