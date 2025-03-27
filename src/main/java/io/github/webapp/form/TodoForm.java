package io.github.webapp.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TodoForm {
    private Integer id;
    private String todo;
    private String detail;
    private boolean isNew;
}
