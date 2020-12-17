package sep3.db.network;

public class DeleteAppointmentPackage extends NetworkPackage {
    private String appointmentId;

    public DeleteAppointmentPackage(NetworkType type, String appointmentId) {
        super(type);
        this.appointmentId = appointmentId;
    }

    public String getAppointmentId() {
        return appointmentId;
    }
}
