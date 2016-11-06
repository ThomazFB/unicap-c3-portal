package org.theorangeteam.portalc3.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Thomaz on 19/03/2016.
 */
public class Discipline
{
    @SerializedName("disciplinaCodigo")
    private String code;

    @SerializedName("disciplinaNome")
    private String name;

    @SerializedName("disciplinaLinkPlanoAcademico")
    private String link;

    @SerializedName("disciplinaCreditos")
    private int credits;

    @SerializedName("disciplinaCargaHoraria")
    private int hours;

    @SerializedName("disciplinaTurno")
    private String shift;

    @SerializedName("disciplinaPeriodo")
    private int semester;

    public String getCode()
    {
        return code;
    }

    public String getName()
    {
        return name;
    }

    public String getLink()
    {
        return link;
    }

    public int getCredits()
    {
        return credits;
    }

    public int getHours()
    {
        return hours;
    }

    public String getShift()
    {
        return shift;
    }

    public int getSemester()
    {
        return semester;
    }
}