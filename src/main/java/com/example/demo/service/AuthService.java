import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;

public interface AuthService {
    AuthResponse authenticate(AuthRequest request);
}
