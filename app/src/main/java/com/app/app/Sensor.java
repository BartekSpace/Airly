package com.app.app;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.UUID;

public class Sensor   {

    @ApiModelProperty(hidden = true)
    private final String id;

    @NotEmpty
   // @Pattern(regexp = "^(.+ .+,){2}.+$")
    @Pattern(regexp = "^[\\wzżźćńółęąśŻŹĆĄŚĘŁÓŃ ]+ [\\w]+,[ \\d-]+ [\\w zżźćńółęąśŻŹĆĄŚĘŁÓŃ]+,[\\wzżźćńółęąśŻŹĆĄŚĘŁÓŃ ]+$")
    @ApiModelProperty(example = "Mogilska 43, 31-545 Kraków, Polska")
    private String address;

    @NotEmpty
    @Pattern(regexp = "^[\\wzżźćńółęąśŻŹĆĄŚĘŁÓŃ]+ [\\wzżźćńółęąśŻŹĆĄŚĘŁÓŃ]+$")
    @ApiModelProperty(example = "John Johnson")
    private String fullName;

    public Sensor( String address, String fullName) {
        this.id = UUID.randomUUID().toString();
        this.address = address;
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getId() {
        return id;
    }


}
