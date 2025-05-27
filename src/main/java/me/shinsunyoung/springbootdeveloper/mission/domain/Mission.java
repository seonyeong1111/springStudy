package me.shinsunyoung.springbootdeveloper.mission.domain;

import jakarta.persistence.*;
import lombok.*;
import me.shinsunyoung.springbootdeveloper.store.domain.Store;
import me.shinsunyoung.springbootdeveloper.global.BaseEntity;
import java.time.LocalDate;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Mission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer reward;

    private LocalDate deadline;

    private String missionSpec;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

}
