package br.com.caiosaderio.demoimobiliaria.model;

/**
 * Created by caiosaderio on 10/3/15.
 */
public class Imovel {

    private Long id;
    private String nome;
    private String telefone;
    private Integer tamanho;
    private Integer tipo;
    private Integer emConstrucao;
    private String obs;
    private Float latitude;
    private Float longitude;
    private String foto;
    private Integer ativo;
    private Integer userCadastrou;
    private Integer favorito;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Integer getTamanho() {
        return tamanho;
    }

    public void setTamanho(Integer tamanho) {
        this.tamanho = tamanho;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public Integer getEmConstrucao() {
        return emConstrucao;
    }

    public void setEmConstrucao(Integer emConstrucao) {
        this.emConstrucao = emConstrucao;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Integer getAtivo() {
        return ativo;
    }

    public void setAtivo(Integer ativo) {
        this.ativo = ativo;
    }

    public Integer getUserCadastrou() {
        return userCadastrou;
    }

    public void setUserCadastrou(Integer userCadastrou) {
        this.userCadastrou = userCadastrou;
    }

    public Integer getFavorito() {
        return favorito;
    }

    public void setFavorito(Integer favorito) {
        this.favorito = favorito;
    }
}
