package ru.aviasales.template.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;

import java.util.List;
import java.util.Map;

import ru.aviasales.core.search.object.GateData;
import ru.aviasales.core.search.object.Proposal;
import ru.aviasales.template.R;
import ru.aviasales.template.ui.adapter.AgencySpinnerAdapter;

public class AgencySpinner extends FrameLayout {

	private CustomSpinner agencySpinner;

	private FrameLayout spinnerContainer;

	private OnAgencyClickedListener listener;

	public interface OnAgencyClickedListener {
		void onAgencyClick(String agency, int position);
	}

	public AgencySpinner(Context context, AttributeSet attrs) {
		super(context, attrs);
		setupView(context);
	}

	private void setupView(Context context) {
		LayoutInflater.from(context).inflate(R.layout.ticket_agency_spinner, this, true);

		agencySpinner = (CustomSpinner) findViewById(R.id.spinner);
		spinnerContainer = (FrameLayout) findViewById(R.id.fl_spinner_container);
		spinnerContainer.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				agencySpinner.performClick();
			}
		});

		agencySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
				agencySpinner.setSelection(0);
			}

			@Override
			public void onNothingSelected(AdapterView<?> adapterView) {
			}
		});

	}

	public void setupAgencies(List<String> agencies, Map<String, GateData> gates, Proposal proposal) {
		final AgencySpinnerAdapter agencyAdapter = new AgencySpinnerAdapter(agencies, gates, proposal);

		if (agencies.size() == 1) {
			spinnerContainer.setVisibility(View.GONE);
		} else {
			spinnerContainer.setVisibility(View.VISIBLE);

			agencyAdapter.setOnAgencyClickListener(new AgencySpinnerAdapter.OnAgencyClickListener() {
				@Override
				public void onAgencyClick(String agency, int position) {

					if (listener != null) {
						hideSpinner();
						listener.onAgencyClick(agency, position);
					}

					agencySpinner.setSelection(0, false);
				}
			});
			agencySpinner.setAdapter(agencyAdapter);
		}
	}

	public void setOnAgencyClickedListener(OnAgencyClickedListener listener) {
		this.listener = listener;
	}

	private void hideSpinner() {
		agencySpinner.onDetachedFromWindow();
	}
}
