package datastreaming.server.model;

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

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "usedclientauthorities",
            joinColumns = @JoinColumn(name = "clientid", referencedColumnName = "clientid"),
            inverseJoinColumns = @JoinColumn(name = "clientauthorityid", referencedColumnName = "id")
    )
    private List<ClientAuthority> clientAuthorities;

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
}
