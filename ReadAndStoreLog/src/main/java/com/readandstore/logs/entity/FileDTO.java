package com.readandstore.logs.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileDTO {
    private List<String> filename;
    public List<String> getFilename() {
        return  filename;
    }
    public void setFilename(List<String> filename) {
        this.filename = filename;
    }
}
