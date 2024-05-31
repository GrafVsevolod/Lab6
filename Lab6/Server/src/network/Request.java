package network;

import models.Organization;

import java.io.Serial;
import java.io.Serializable;

public class Request implements Serializable {
    @Serial
    private static final long serialVersionUID = -2198189148456433400L;
    private Organization organization;
    private String[] args;

    public Request(Organization organization){
        this.organization = organization;
    }

    public Request(Organization organization, String[] args){
        this.organization = organization;
        this.args = args;
    }

    public Request(String[] args){
        this.args = args;
    }

    public String[] getArgs(){
        return args;
    }

    public Organization getOrganization(){
        return organization;
    }

}
