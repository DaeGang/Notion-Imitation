package com.daegang.notion.article.infra;

import com.daegang.notion.article.domain.Article;
import com.daegang.notion.common.exception.InvalidIdFormatException;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class ArticleRepositoryImpl implements ArticleRepository {
    private static final RowMapper<ArticleEntity> ARTICLE_ROW_MAPPER = (rs, rowNum) -> ArticleEntity.builder()
                                                                                                    .id(rs.getLong("article_id"))
                                                                                                    .title(rs.getString("title"))
                                                                                                    .content(rs.getString("content"))
                                                                                                    .parentId(rs.getLong("parent_id"))
                                                                                                    .build();

    private static final RowMapper<ArticleEntity> ARTICLES_ROW_MAPPER = (rs, rowNum) -> ArticleEntity.builder()
                                                                                                        .id(rs.getLong("article_id"))
                                                                                                        .title(rs.getString("title"))
                                                                                                        .parentId(rs.getLong("parent_id"))
                                                                                                        .build();

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Optional<Article> findById(String id) {
        String sql = "SELECT * FROM ARTICLE WHERE article_id = :article_id";
        return Optional.ofNullable(namedParameterJdbcTemplate.queryForObject(sql, generateParams(id), ARTICLE_ROW_MAPPER))
                .map(ArticleEntity::toDomain);
    }

    @Override
    public List<Article> findSubPagesByParentId(String id) {
        String sql = "SELECT * FROM ARTICLE WHERE parent_id = :article_id";
        return namedParameterJdbcTemplate.query(sql, generateParams(id), ARTICLES_ROW_MAPPER).stream()
                .map(ArticleEntity::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Article> findBreadCrumbsByParentId(String id) {
        String sql = """
                WITH RECURSIVE breadcrumbs AS (
                    SELECT article_id, title, parent_id
                    FROM ARTICLE
                    WHERE article_id = :article_id
                    
                    UNION ALL
                    
                    SELECT a.article_id, a.title, a.parent_id
                    FROM ARTICLE a
                    INNER JOIN breadcrumbs b ON a.article_id = b.parent_id
                )
                
                SELECT *
                FROM breadcrumbs
                ORDER BY article_id DESC
                """;

        return namedParameterJdbcTemplate.query(sql, generateParams(id), ARTICLES_ROW_MAPPER).stream()
                .map(ArticleEntity::toDomain)
                .collect(Collectors.toList());
    }

    private SqlParameterSource generateParams(String id) {
        return new MapSqlParameterSource()
                .addValue("article_id", parseLong(id));
    }

    private Long parseLong(String str) {
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException ex) {
            throw new InvalidIdFormatException(ex.getMessage());
        }
    }
}
