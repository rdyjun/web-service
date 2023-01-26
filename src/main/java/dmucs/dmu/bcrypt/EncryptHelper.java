package dmucs.dmu.bcrypt;

import org.mindrot.jbcrypt.BCrypt;

public interface EncryptHelper {

    public String encrypt (String password);
    public boolean isMatch(String password, String hashed);
}
