package htp.by.ramanouski.filesystem.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MessageException {
    private int status;
    private long timestamp;
    private String message;
}
