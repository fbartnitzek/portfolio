package name.abuchen.portfolio.ui.views.columns;

import name.abuchen.portfolio.model.Adaptor;
import name.abuchen.portfolio.model.InvestmentVehicle;
import name.abuchen.portfolio.ui.util.Column;
import name.abuchen.portfolio.ui.util.ColumnViewerSorter;

import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.swt.SWT;

public class CurrencyColumn extends Column
{
    public static class CurrencyColumnLabelProvider extends ColumnLabelProvider
    {
        @Override
        public String getText(Object e)
        {
            InvestmentVehicle n = Adaptor.adapt(InvestmentVehicle.class, e);
            return n != null ? n.getCurrencyCode() : null;
        }
    }

    public CurrencyColumn()
    {
        this("currency", "Währung", SWT.LEFT, 60); //$NON-NLS-1$
    }

    public CurrencyColumn(String id, String label, int style, int defaultWidth)
    {
        super(id, label, style, defaultWidth);

        setLabelProvider(new CurrencyColumnLabelProvider());
        setSorter(ColumnViewerSorter.create(InvestmentVehicle.class, "currencyCode")); //$NON-NLS-1$
    }
}
