package Jama;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Vector3DTest {

    @Test
    void scalarProduct_orthogonaux() {
        Vector3D u = new Vector3D(new double[]{0, 10, 0});
        Vector3D v = new Vector3D(new double[]{10, 0, 0});

        double result = u.scalarProduct(v);
        assertEquals(0.00, result);
    }

    @Test
    void scalarProduct_colineaire() {
        Vector3D u = new Vector3D(new double[]{0, 10, 0});
        Vector3D v = new Vector3D(new double[]{0, 20, 0});

        double result = u.scalarProduct(v);
        assertEquals(200.00, result);
    }

    @Test
    void scalarProduct_quelconque() {
        Vector3D u = new Vector3D(new double[]{1, 2, 3});
        Vector3D v = new Vector3D(new double[]{4, 5, 6});

        double result = u.scalarProduct(v);
        assertEquals(32.00, result);
    }

    @Test
    void vectorProduct() {
        Vector3D u = new Vector3D(new double[]{2, 2, 0});
        Vector3D v = new Vector3D(new double[]{0, 10, 0});
        Vector3D W_RESULT = new Vector3D(new double[]{0, 0, 20});

        Vector3D w = u.vectorProduct(v);

        assertNotNull(w);
        assertEquals(W_RESULT, w);
    }
}
