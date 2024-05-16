package br.com.gabriel.cache.records;

import java.io.Serializable;

public record Product(Long id, String name, String description) implements Serializable {
}
