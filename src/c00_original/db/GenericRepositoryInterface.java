package db;

import java.util.List;

/**
 * 공통 저장소 인터페이스
 * @param <T> 엔티티 타입
 */
public interface GenericRepositoryInterface<T> {
    /**
     * 데이터 삽입
     * @param entity 삽입할 엔티티
     * @return 성공 시 1, 실패 시 0
     */
    int insert(T entity);
    
    /**
     * 전체 데이터 조회
     * @return 전체 데이터 리스트
     */
    List<T> findAll();
    
    /**
     * ID로 데이터 조회
     * @param id 검색할 ID
     * @return 찾은 엔티티, 없으면 null
     */
    T find(String id);
    
    /**
     * 데이터 수정
     * @param entity 수정할 엔티티
     * @return 성공 시 1, 실패 시 0
     */
    int update(T entity);
    
    /**
     * 데이터 삭제
     * @param id 삭제할 ID
     * @return 성공 시 1, 실패 시 0
     */
    int remove(String id);
    
    /**
     * 전체 데이터 개수 조회
     * @return 전체 데이터 개수
     */
    int getCount();
}
