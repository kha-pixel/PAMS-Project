
import org.junit.Test;
import static org.junit.Assert.*;

public class AppointmentBSTTest {
    @Test
    public void testAddAppointment() {
        AppointmentBST bst = new AppointmentBST();
        PatientAppointment p1 = new PatientAppointment(1, "Test Patient", "09:00");
        bst.addAppointment(p1);
        assertNotNull(bst.getRoot());
    }

    @Test
    public void testAddMultipleAppointmentsInOrder() {
        AppointmentBST bst = new AppointmentBST();
        PatientAppointment p1 = new PatientAppointment(1, "Patient One", "09:00");
        PatientAppointment p2 = new PatientAppointment(2, "Patient Two", "10:00");
        PatientAppointment p3 = new PatientAppointment(3, "Patient Three", "08:00");

        bst.addAppointment(p1);
        bst.addAppointment(p2);
        bst.addAppointment(p3);

        AppointmentNode root = bst.getRoot();
        assertEquals(p1, root.data); // 09:00 is root
        assertEquals(p3, root.left.data); // 08:00 left of 09:00
        assertEquals(p2, root.right.data); // 10:00 right of 09:00
    }

    @Test
    public void testPreventDuplicateAppointmentTime() {
        AppointmentBST bst = new AppointmentBST();
        PatientAppointment p1 = new PatientAppointment(1, "Patient One", "09:00");
        PatientAppointment p2 = new PatientAppointment(2, "Patient Duplicate", "09:00");

        bst.addAppointment(p1);
        bst.addAppointment(p2); // Should not be added

        AppointmentNode root = bst.getRoot();
        assertEquals("Patient One", root.data.patientName);
        assertNull(root.left);
        assertNull(root.right);
    }
}
