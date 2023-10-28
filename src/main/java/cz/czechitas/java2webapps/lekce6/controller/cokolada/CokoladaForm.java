package cz.czechitas.java2webapps.lekce6.controller.cokolada;

import cz.czechitas.java2webapps.lekce6.controller.alkohol.Objem;
import jakarta.validation.constraints.*;

/**
 */
public class CokoladaForm {
  @NotBlank
  private String zbozi;

  @NotBlank
  private String jmeno;
  @Min(18)
  @Max(150)
  private int vek;
  @Email
  @NotBlank
  private String email;
  @AssertTrue
  private boolean obchodniPodminky;

  public String getZbozi() {
    return zbozi;
  }

  public void setZbozi(String zbozi) {
    this.zbozi = zbozi;
  }

  public String getJmeno() {
    return jmeno;
  }

  public void setJmeno(String jmeno) {
    this.jmeno = jmeno;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public boolean isObchodniPodminky() {
    return obchodniPodminky;
  }

  public void setObchodniPodminky(boolean obchodniPodminky) {
    this.obchodniPodminky = obchodniPodminky;
  }

  public int getVek() {
    return vek;
  }

  public void setVek(int vek) {
    this.vek = vek;
  }

}
