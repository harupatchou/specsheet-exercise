package com.example.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.management.domain.ProcessDefine;
/**
 * OS関連リポジトリクラス.
 * @author takayuki.honma
 *
 */
@Repository
public interface ProcessDefineRepository extends JpaRepository<ProcessDefine, Integer>{
}
