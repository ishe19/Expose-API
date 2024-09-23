package zw.co.revenant.expose.features.leaks.models.dto;

import java.util.Date;

public record LeakDto(String title, String leakCode, String description, Date postedOn) {
}
