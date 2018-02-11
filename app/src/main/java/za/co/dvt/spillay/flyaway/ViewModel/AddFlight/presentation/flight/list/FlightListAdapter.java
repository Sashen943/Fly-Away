package za.co.dvt.spillay.flyaway.ViewModel.AddFlight.presentation.flight.list;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import za.co.dvt.spillay.flyaway.R;
import za.co.dvt.spillay.flyaway.ViewModel.AddFlight.data.Flight;


public class FlightListAdapter extends RecyclerView.Adapter<FlightListAdapter.FlightViewHolder> {
    private List<Flight> flights;

    class FlightViewHolder extends RecyclerView.ViewHolder {
        TextView fromTextView;
        TextView toTextView;
        TextView dateTextView;
        TextView timeTextView;
        TextView referenceNumberTextView;

        private FlightViewHolder(View itemView) {
            super(itemView);
            fromTextView = itemView.findViewById(R.id.txt_flight_from);
            toTextView = itemView.findViewById(R.id.txt_flight_to);
            timeTextView = itemView.findViewById(R.id.txt_flight_time);
            dateTextView = itemView.findViewById(R.id.txt_flight_date);
            referenceNumberTextView = itemView.findViewById(R.id.txt_flight_reference);

        }
    }

    @Override
    public FlightViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new FlightViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FlightViewHolder holder, int position) {
        Flight flight = flights.get(position);

        holder.fromTextView.setText(flight.getFrom());
        holder.toTextView.setText(flight.getTo());
        holder.dateTextView.setText("Date: " + flight.getDate());
        holder.referenceNumberTextView.setText(flight.getReferenceNumber());
        holder.timeTextView.setText("Time: " + flight.getTime());
    }

    @Override
    public int getItemCount() {
        if (flights == null) {
            return 0;
        }
        return flights.size();
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
        notifyDataSetChanged();
    }
}
