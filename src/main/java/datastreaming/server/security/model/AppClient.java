package datastreaming.server.security.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "clients")
public class AppClient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "clientid")
    private Long id;

    @Column(name = "clientname")
    @NotNull
    private String clientName;

    @Column(name = "clientsecret")
    @NotNull
    private String clientSecret;

    @ManyToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(
            name = "usedclientauthorities",
            joinColumns = @JoinColumn(name = "clientid", referencedColumnName = "clientid"),
            inverseJoinColumns = @JoinColumn(name = "clientauthorityid", referencedColumnName = "id")
    )
    private List<ClientAuthority> clientAuthorities;

    @Column(name = "accesstokenvalidity")
    private Integer accessTokenValiditySeconds;

    @Column(name = "refreshtokenvalidity")
    private Integer refreshTokenValiditySeconds;

    @ManyToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(
            name = "usedclientgranttypes",
            joinColumns = @JoinColumn(name = "clientid", referencedColumnName = "clientid"),
            inverseJoinColumns = @JoinColumn(name = "granttypeid", referencedColumnName = "id")
    )
    private List<ClientGrantType> clientGrantTypes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public List<ClientAuthority> getClientAuthorities() {
        return clientAuthorities;
    }

    public void setClientAuthorities(List<ClientAuthority> clientAuthorities) {
        this.clientAuthorities = clientAuthorities;
    }

    public Integer getAccessTokenValiditySeconds() {
        return accessTokenValiditySeconds;
    }

    public void setAccessTokenValiditySeconds(Integer accessTokenValiditySeconds) {
        this.accessTokenValiditySeconds = accessTokenValiditySeconds;
    }

    public Integer getRefreshTokenValiditySeconds() {
        return refreshTokenValiditySeconds;
    }

    public void setRefreshTokenValiditySeconds(Integer refreshTokenValiditySeconds) {
        this.refreshTokenValiditySeconds = refreshTokenValiditySeconds;
    }

    public List<ClientGrantType> getClientGrantTypes() {
        return clientGrantTypes;
    }

    public void setClientGrantTypes(List<ClientGrantType> clientGrantTypes) {
        this.clientGrantTypes = clientGrantTypes;
    }
}
