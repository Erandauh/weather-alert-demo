
package org.example.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Clouds {

    @SerializedName("all")
    @Expose
    public Integer all;

}
