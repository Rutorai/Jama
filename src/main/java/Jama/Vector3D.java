package Jama;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.stream.IntStream;

@Data
@Builder
public class Vector3D implements Cloneable, Serializable {
    private double[] coordinates;

    public double scalarProduct(Vector3D vector) {
        if ((vector == null)
            || (coordinates == null)
            || (vector.coordinates == null)
            || (coordinates.length != 3)
            || (coordinates.length != vector.coordinates.length)) throw new IllegalArgumentException();

        return IntStream.range(0, 3)
            .mapToDouble(index -> coordinates[index] * vector.coordinates[index])
            .sum();
    }

    public Vector3D vectorProduct(Vector3D vector) {
        if ((vector == null)
            || (coordinates == null)
            || (vector.coordinates == null)
            || (coordinates.length != 3)
            || (coordinates.length != vector.coordinates.length)) throw new IllegalArgumentException();

        return Vector3D.builder()
            .coordinates(new double[]{
                coordinates[1] * vector.coordinates[2] - coordinates[2] * vector.coordinates[1],
                coordinates[2] * vector.coordinates[0] - coordinates[0] * vector.coordinates[2],
                coordinates[0] * vector.coordinates[1] - coordinates[1] * vector.coordinates[0]
            })
            .build();
    }
}
