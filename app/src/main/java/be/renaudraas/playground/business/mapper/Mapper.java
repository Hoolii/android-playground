package be.renaudraas.playground.business.mapper;

public interface Mapper<From, To> {
    To map(From from);
}