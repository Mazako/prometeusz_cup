package pl.mazak.backend.persistance;

public record TeamWithCaptain(long teamId, String name, String captainName, int captainAvatarId) {
}
