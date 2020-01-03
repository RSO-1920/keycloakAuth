package si.fri.rso.lib;

import java.lang.reflect.Array;
import java.util.List;

public class KeycloakUserDTO {

    private boolean totp;
    private String lastName;
    private KeycloakAccessDTO access;
    private float createdTimestamp;
    private String authToken;
    private boolean enabled;
    private float notBefore;
    private List disableableCredentialTypes;
    private boolean emailVerified;
    private String firstName;
    private List requiredActions;
    private String id;
    private String email;
    private String username;

    public boolean isTotp() {
        return totp;
    }

    public void setTotp(boolean totp) {
        this.totp = totp;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String bbb) {
        this.lastName = bbb;
    }

    public KeycloakAccessDTO getAccess() {
        return access;
    }

    public void setAccess(KeycloakAccessDTO keycloakAccess) {
        this.access = keycloakAccess;
    }

    public float getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setCreatedTimestamp(float createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public float getNotBefore() {
        return notBefore;
    }

    public void setNotBefore(float notBefore) {
        this.notBefore = notBefore;
    }

    public List getDisableableCredentialTypes() {
        return disableableCredentialTypes;
    }

    public void setDisableableCredentialTypes(List disableableCredentialTypesM) {
        this.disableableCredentialTypes = disableableCredentialTypesM;
    }

    public boolean isEmailVerified() {
        return emailVerified;
    }

    public void setEmailVerified(boolean emailVerified) {
        this.emailVerified = emailVerified;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public List getRequiredActions() {
        return requiredActions;
    }

    public void setRequiredActions(List requiredActions) {
        this.requiredActions = requiredActions;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
