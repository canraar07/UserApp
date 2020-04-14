package com.andi.userapp.data;

import com.google.gson.annotations.SerializedName;

public class ObjectProblem {
    @SerializedName("notiket")
    String notiket;
    @SerializedName("asignto")
    String asignto;
    @SerializedName("namaplapor")
    String namaplapor;
    @SerializedName("asetid")
    String asetid;
    @SerializedName("asetname")
    String asetname;
    @SerializedName("asetserial")
    String asetserial;
    @SerializedName("asetbrand")
    String asetbrand;
    @SerializedName("problem")
    String problem;
    @SerializedName("status")
    String status;
    @SerializedName("notes")
    String notes;
    @SerializedName("idplapor")
    String idplapor;
    @SerializedName("tgllapor")
    String tgllapor;

    public ObjectProblem(){}

    public ObjectProblem(String notiket, String asignto, String namaplapor, String asetid, String asetname,
                         String asetserial, String asetbrand, String problem, String status, String notes,
                         String idplapor, String tgllapor
                         ){
        this.notiket = notiket;
        this.asignto = asignto;
        this.namaplapor = namaplapor;
        this.asetid = asetid;
        this.asetname = asetname;
        this.asetserial = asetserial;
        this.asetbrand = asetbrand;
        this.problem = problem;
        this.status = status;
        this.notes = notes;
        this.idplapor = idplapor;
        this.tgllapor = tgllapor;
    }

    public String getNotiket() {
        return notiket;
    }

    public void setNotiket(String notiket) {
        this.notiket = notiket;
    }

    public String getAsignto() {
        return asignto;
    }

    public void setAsignto(String asignto) {
        this.asignto = asignto;
    }

    public String getNamaplapor() {
        return namaplapor;
    }

    public void setNamaplapor(String namaplapor) {
        this.namaplapor = namaplapor;
    }

    public String getAsetid() {
        return asetid;
    }

    public void setAsetid(String asetid) {
        this.asetid = asetid;
    }

    public String getAsetname() {
        return asetname;
    }

    public void setAsetname(String asetname) {
        this.asetname = asetname;
    }

    public String getAsetserial() {
        return asetserial;
    }

    public void setAsetserial(String asetserial) {
        this.asetserial = asetserial;
    }

    public String getAsetbrand() {
        return asetbrand;
    }

    public void setAsetbrand(String asetbrand) {
        this.asetbrand = asetbrand;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getIdplapor() {
        return idplapor;
    }

    public void setIdplapor(String idplapor) {
        this.idplapor = idplapor;
    }

    public String getTgllapor() {
        return tgllapor;
    }

    public void setTgllapor(String tgllapor) {
        this.tgllapor = tgllapor;
    }
}
