package org.example.file.exceptions;

public class FileRWException extends RuntimeException{
    String reason;

    public FileRWException(String reason){
        this.reason=reason;
    }
    public FileRWException(String reason, Throwable cause){
        super(cause);
        this.reason =reason;
    }

    public String getReason(){
        return this.reason;
    }
}
