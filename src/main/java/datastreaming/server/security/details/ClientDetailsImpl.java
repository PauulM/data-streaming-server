package datastreaming.server.security.details;

import datastreaming.server.security.model.AppClient;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;

import java.util.*;
import java.util.stream.Collectors;

public class ClientDetailsImpl implements ClientDetails {

    private AppClient appClient;

    private final String ROLE_PREFIX = "ROLE_";

    public ClientDetailsImpl(AppClient appClient) {
        this.appClient = appClient;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String getClientId() {
        return appClient.getClientName();
    }

    @Override
    public Set<String> getResourceIds() {
        return new HashSet<>();
    }

    @Override
    public boolean isSecretRequired() {
        return true;
    }

    @Override
    public String getClientSecret() {
        return appClient.getClientSecret();
    }

    @Override
    public boolean isScoped() {
        return false;
    }

    @Override
    public Set<String> getScope() {
        HashSet<String> scopes = new HashSet<>();
        scopes.add("USE_APP");
        return scopes;
    }

    @Override
    public Set<String> getAuthorizedGrantTypes() {
        return appClient.getClientGrantTypes()
                .stream()
                .map(grantType -> grantType.getName())
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getRegisteredRedirectUri() {
        return new HashSet<>();
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return appClient.getClientAuthorities()
                .stream()
                .map(authority -> {
                    return new SimpleGrantedAuthority(ROLE_PREFIX + authority.getName());
                })
                .collect(Collectors.toSet());
    }

    @Override
    public Integer getAccessTokenValiditySeconds() {
        return appClient.getAccessTokenValiditySeconds();
    }

    @Override
    public Integer getRefreshTokenValiditySeconds() {
        return appClient.getRefreshTokenValiditySeconds();
    }

    @Override
    public boolean isAutoApprove(String s) {
        return false;
    }

    @Override
    public Map<String, Object> getAdditionalInformation() {
        return new HashMap<>();
    }
}
