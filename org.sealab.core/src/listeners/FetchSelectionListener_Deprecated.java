package listeners;

import java.util.List;

import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;

import model.Db;
import model.EOL_Library_DO_Operation;
import model.EOL_Library_F_Operation;


public class FetchSelectionListener_Deprecated implements SelectionListener {

	private org.eclipse.swt.widgets.List EolMetricList, EolDoList, EolThList;
	private List<Integer> DBMetricFunctions, DBDoFunctions, DBThresholdFunctions;


	public FetchSelectionListener_Deprecated(org.eclipse.swt.widgets.List MetricList, org.eclipse.swt.widgets.List DoList, org.eclipse.swt.widgets.List ThList, List<Integer> MetricFunctions, List<Integer> DoFunctions, List<Integer> ThresholdFunctions) {
		
		this.EolMetricList = MetricList;
		this.EolDoList = DoList;
		this.EolThList = ThList;
		this.DBMetricFunctions = MetricFunctions;
		this.DBDoFunctions = DoFunctions;
		this.DBThresholdFunctions = ThresholdFunctions;
	}

	public void widgetSelected(SelectionEvent event) {


		try {
			List<Integer> f_id_list = Db.getall_F_id();
			
			EolMetricList.removeAll();
			DBMetricFunctions.clear();
			
			for (Integer id : f_id_list) {
				
				EOL_Library_F_Operation f = Db.get_F_description_byId(id);
				
				EolMetricList.add(f.getName() + " for " + f.getContext());
				
				DBMetricFunctions.add(id);
				
			}
		} catch (Exception e1) {
			EolMetricList.removeAll();
			EolMetricList.add("DB error - " + e1.getMessage());
		}
		
		
		try {
			List<Integer> do_id_list = Db.getall_Do_id();
			
			EolDoList.removeAll();
			DBDoFunctions.clear();
			
			for (Integer id : do_id_list) {
				
				EOL_Library_DO_Operation redo = Db.get_Do_description_byId(id);
				
				EolDoList.add(redo.getName() + " for " + redo.getContext());
				
				DBDoFunctions.add(id);
				
			}
		} catch (Exception e1) {
			EolDoList.removeAll();
			EolDoList.add("DB error");
		}
		
		
		try {
			List<Integer> th_id_list = Db.getall_Th_id();
			
			EolThList.removeAll();
			DBThresholdFunctions.clear();
			
			for (Integer id : th_id_list) {
				
				String th_name = Db.get_Th_name_byId(id);
				
				EolThList.add(th_name);
				
				DBThresholdFunctions.add(id);
				
			}
		} catch (Exception e1) {
			EolThList.removeAll();
			EolThList.add("DB error");
		}
      }

      public void widgetDefaultSelected(SelectionEvent event) {


      }
}
