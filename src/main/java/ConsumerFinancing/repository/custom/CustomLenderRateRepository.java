package ConsumerFinancing.repository.custom;

import ConsumerFinancing.entity.LenderRate;

import java.util.List;

public interface CustomLenderRateRepository {

    List<LenderRate> getLenderRates(
            String livingStatus, String lenderName, int assetAge, int creditScore
    );

}
