package com.example.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.management.domain.LanguageDefine;

/**
 * 言語定義リポジトリクラス.
 * @author takayuki.honma
 *
 */
@Repository
public interface LanguageDefineRepository extends JpaRepository<LanguageDefine, String>{
}
