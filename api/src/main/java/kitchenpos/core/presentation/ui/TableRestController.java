package kitchenpos.core.presentation.ui;

import java.net.URI;
import java.util.List;
import kitchenpos.core.application.TableService;
import kitchenpos.core.domain.ordertable.OrderTable;
import kitchenpos.core.dto.request.OrderTableCreateRequest;
import kitchenpos.core.dto.request.OrderTableUpdateEmptyRequest;
import kitchenpos.core.dto.request.OrderTableUpdateNumberOfGuestsRequest;
import kitchenpos.core.dto.response.OrderTableResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TableRestController {
    private final TableService tableService;

    public TableRestController(final TableService tableService) {
        this.tableService = tableService;
    }

    @PostMapping("/api/tables")
    public ResponseEntity<OrderTableResponse> create(@RequestBody final OrderTableCreateRequest request) {
        final OrderTable created = tableService.create(request);
        final URI uri = URI.create("/api/tables/" + created.getId());
        return ResponseEntity.created(uri)
                .body(OrderTableResponse.from(created))
                ;
    }

    @GetMapping("/api/tables")
    public ResponseEntity<List<OrderTableResponse>> list() {
        final List<OrderTable> tables = tableService.list();
        return ResponseEntity.ok()
                .body(OrderTableResponse.of(tables))
                ;
    }

    @PutMapping("/api/tables/{orderTableId}/empty")
    public ResponseEntity<OrderTableResponse> changeEmpty(
            @PathVariable final Long orderTableId,
            @RequestBody final OrderTableUpdateEmptyRequest request
    ) {
        final OrderTable orderTable = tableService.changeEmpty(orderTableId, request);
        return ResponseEntity.ok()
                .body(OrderTableResponse.from(orderTable))
                ;
    }

    @PutMapping("/api/tables/{orderTableId}/number-of-guests")
    public ResponseEntity<OrderTableResponse> changeNumberOfGuests(
            @PathVariable final Long orderTableId,
            @RequestBody final OrderTableUpdateNumberOfGuestsRequest request
    ) {
        final OrderTable orderTable = tableService.changeNumberOfGuests(orderTableId, request);
        return ResponseEntity.ok()
                .body(OrderTableResponse.from(orderTable))
                ;
    }
}