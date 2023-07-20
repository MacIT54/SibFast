package ru.cft.shift.intensive.template.dto;

import java.util.List;

public record OrderDto (
    List<PurchaseDto> purchases,
    String destination
) {
}

