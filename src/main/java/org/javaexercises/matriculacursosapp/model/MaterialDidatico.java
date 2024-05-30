package org.javaexercises.matriculacursosapp.model;

import jakarta.persistence.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="materiaisdidaticos")
public class MaterialDidatico {
    @Id
    private String id;
    private String descricao;
    private String autor;
    private String areaAcademica;
    @Version
    Integer version;

    public MaterialDidatico(String id, String descricao, String autor, String areaAcademica) {
        this.id = id;
        this.descricao = descricao;
        this.autor = autor;
        this.areaAcademica = areaAcademica;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getAreaAcademica() {
        return areaAcademica;
    }

    public void setAreaAcademica(String areaAcademica) {
        this.areaAcademica = areaAcademica;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
