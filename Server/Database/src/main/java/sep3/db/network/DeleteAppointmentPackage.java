package sep3.db.network;

/**
 * The type Delete appointment package.
 */
public class DeleteAppointmentPackage extends NetworkPackage {
    private String appointmentId;

    /**
     * Instantiates a new Delete appointment package.
     *
     * @param type          the type
     * @param appointmentId the appointment id
     */
    public DeleteAppointmentPackage(NetworkType type, String appointmentId) {
        super(type);
        this.appointmentId = appointmentId;
    }

    /**
     * Gets appointment id.
     *
     * @return the appointment id
     */
    public String getAppointmentId() {
        return appointmentId;
    }
}
