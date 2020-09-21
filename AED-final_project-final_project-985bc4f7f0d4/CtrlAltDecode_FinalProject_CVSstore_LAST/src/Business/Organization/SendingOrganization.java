/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.Role;
import Business.Role.SendingRole;
import java.util.ArrayList;

/**
 *
 * @author xtdon
 */
public class SendingOrganization extends Organization {
    public SendingOrganization() {
        super(Organization.Type.Sending.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new SendingRole());
        return roles;
    }
}