import java.time.Duration;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

public class Session {
  private final String id;
  private final String userId;
  private final Instant createdAt;
  private Instant expiresAt;
  public static final Duration DEFAULT_DURATION = Duration.ofHours(1);

  public Session(String userId) {
    this(userId, DEFAULT_DURATION);
  }

  public Session(String userId, Duration duration) {
    this.id = UUID.randomUUID().toString();
    this.userId = Objects.requireNonNull(userId, "userId");
    this.createdAt = Instant.now();
    this.expiresAt = createdAt.plus(duration == null ? DEFAULT_DURATION : duration);
  }

  public String getId() {
    return id;
  }

  public String getUserId() {
    return userId;
  }

  public Instant getCreatedAt() {
    return createdAt;
  }

  public Instant getExpiresAt() {
    return expiresAt;
  }

  public boolean isExpired() {
    return Instant.now().isAfter(expiresAt);
  }

  public void renew(Duration duration) {
    Duration d = duration == null ? DEFAULT_DURATION : duration;
    this.expiresAt = Instant.now().plus(d);
  }

  public void invalidate() {
    this.expiresAt = Instant.EPOCH;
  }

  @Override
  public String toString() {
    return "Session{" +
        "id='" + id + '\'' +
        ", userId='" + userId + '\'' +
        ", createdAt=" + createdAt +
        ", expiresAt=" + expiresAt +
        '}';
  }
}
