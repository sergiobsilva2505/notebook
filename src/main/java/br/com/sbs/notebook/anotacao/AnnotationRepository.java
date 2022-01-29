package br.com.sbs.notebook.anotacao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AnnotationRepository extends JpaRepository<Annotation, Long> {

    List<Annotation> findByAnnotationType(AnnotationType annotationType);

    Optional<Annotation> findAnnotationById(Long id);

    @Query(value = """
        SELECT IF(
            EXISTS(
                SELECT 1 FROM annotations
                WHERE description = :description
                    AND type = :type
                    AND MONTH(created_at) = :month
                    AND YEAR(created_at) = :year
                LIMIT 1
            ), 'true', 'false'
        ) 
        """, nativeQuery = true)
    boolean exists(@Param("description") String description, @Param("type") String type, @Param("month") int month, @Param("year") int year);


    default boolean exists(Annotation annotation) {
        return exists(annotation.getDescription(), annotation.getAnnotationType().toString(), annotation.getCreatedAt().getMonthValue(), annotation.getCreatedAt().getYear());
    }

    Optional<Annotation> findByIdAndAnnotationType(Long id, AnnotationType annotationType);
}
