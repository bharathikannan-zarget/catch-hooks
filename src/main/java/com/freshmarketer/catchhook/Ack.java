package com.freshmarketer.catchhook;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Ack {

    int status;
    String message;

}
