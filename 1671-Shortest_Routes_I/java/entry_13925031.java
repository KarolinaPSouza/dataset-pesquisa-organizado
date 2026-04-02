import java.io.*;
import static java.lang.System.err;
import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import static java.lang.Math.*; 
import static java.lang.String.*;
import static java.util.Arrays.*;
import static java.util.Comparator.*;
import static java.util.stream.IntStream.*;
import static java.util.stream.Collectors.*;
import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import static java.util.Arrays.stream;
import static java.util.stream.IntStream.range;
import static java.util.Spliterator.ORDERED;
import static java.util.Spliterators.spliteratorUnknownSize;
import static java.util.stream.Collectors.*;
import static java.lang.System.out;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.Callable;

public class entry_13925031 implements Runnable {
    static int N = (int) (1E6 + 1);
    static int M = (int) (1E6 + 1);
    static int G = 1 << 12;
    static int NONE = -1;
    static IO io = new IO();

    long[] solve(int n, int m, int[][] E) {
        var G = AdjList.of(n, E);
        var D = new long[n];
        Arrays.fill(D, INFL);
        var pq = new PriorityQueue<long[]>((a,b) -> a[0] < b[0] ? -1 : a[0] > b[0] ? +1 : 0);
        D[0] = 0;
        pq.offer(new long[] {0,0});
        while(!pq.isEmpty()) {
            long d = pq.peek()[0];
            var u = (int) pq.peek()[1];
            pq.poll();
            if(D[u] < d) {
                continue;
            }
            for(var vw: G[u]) {
                var v = vw[0];
                var w = vw[1];
                long alt = d+w;
                if(alt < D[v]) {
                    D[v] = alt;
                    pq.offer(new long[] {alt, v});
                }
            }
        }
        return D;
    }
    @Override public void run() {
        var n = io.ni();
        var m = io.ni();
        var E = io.nim(m, 3, new int[] {-1,-1,0});
        var ans = solve(n, m, E);
        io.println(ans, " ");
        io.close();
    }
    public static void main(String[] args) throws Exception {
        Thread t = new Thread(null, new entry_13925031(), "", 1 << 28);
        t.setPriority(Thread.MAX_PRIORITY);
        t.start();
    }
    static class AdjList extends ArrayList<int[]> {
        static AdjList[] of(int n) {
            var ans = new AdjList[n];
            Arrays.setAll(ans, __ -> new AdjList());
            return ans;
        }
        static AdjList[] of(int n, int[][] E) {
            var ans = AdjList.of(n);
            for(var e: E) {
                var u = e[0];
                var v = e[1];
                var w = e[2];
                ans[u].add(new int[] {v, w});
            }
            return ans;
        }
    }


    static final int TARGET_BIT = 2;
    static final int REACHED_BIT = 3;
    static final int  ϵ = 0,  π = 1, £ = 2, H  = 3, δ = 4, K = 5, I = 6, Ti = 7, Tχ = 8, IS = 9, Ω = 10, F = 11, at = 12, L = 13;

    interface Memory {
        enum Storage {
            INSTANCE;
            int[][] buf = new int[14][N];
        }

        boolean is_target                   (int uid);
        boolean is_reached                  (int uid);
        boolean is_leader                   (int uid);
        boolean is_entered                  (int uid);
        boolean is_exited                   (int uid);
        void    set_target                  (int uid);
        void    set_reached                 (int uid);

        int     tin_to_uid                  (int tin);
        int     rank_to_uid                 (int rank);

        int     pv                          (int uid);
        int     pe                          (int uid);
        int     depth                       (int uid);
        int     tin                         (int uid);
        int     tex                         (int uid);
        int     low                         (int uid);
        int     root                        (int uid);
        int     cid                         (int uid);
        int     rank                        (int uid);
        int     score                       (int uid);
        void    set_pe                      (int uid, int pe);
        void    set_low                     (int uid, int low);
        void    set_score                   (int uid, int score);
        void    set_tin_and_low             (int uid, int tin);
        void    set_pv                      (int uid, int pv);
        void    set_tex_and_update_low      (int uid, int tex);
        void    set_rank_and_cid            (int uid, int rank, int cid);

        static Memory of(Graph G) {
            var M           = Storage.INSTANCE.buf;
            var gid         = G.id();
            var ¢           = gon[gid];
            Arrays.fill(M[ Ti ] , gon[gid], gon[gid+1], IntID.NONE);
            Arrays.fill(M[ Tχ ] , gon[gid], gon[gid+1], IntID.NONE);
            Arrays.fill(M[ IS ] , gon[gid], gon[gid+1], IntID.ZERO);
            return new Memory() {
                public boolean is_target           (int uid)           { return (((M[ IS ][ ¢+uid ] >> TARGET_BIT ) & 1) == 1); }
                public boolean is_reached          (int uid)           { return (((M[ IS ][ ¢+uid ] >> REACHED_BIT) & 1) == 1); }
                public boolean is_leader           (int uid)           { return depth(uid) == 0;       }
                public boolean is_entered          (int uid)           { return tin(uid) != NONE;      }
                public boolean is_exited           (int uid)           { return tex(uid) != NONE;      }
                public void    set_target          (int uid)           {        M[ IS ][ ¢+uid ] |=  (1 << TARGET_BIT );  }
                public void    set_reached         (int uid)           {        M[ IS ][ ¢+uid ] |=  (1 << REACHED_BIT);  }
                public int     tin_to_uid          (int tin)           { return M[ at ][ ¢+ tin  ]; }
                public int     rank_to_uid         (int rank)          { return M[ Ω  ][ ¢+ rank ]; }
                public int     score               (int uid)           { return M[ £  ][ ¢+uid ]; }
                public int     pv                  (int uid)           { return M[ π  ][ ¢+uid ]; }
                public int     pe                  (int uid)           { return M[ ϵ  ][ ¢+uid ]; }
                public int     depth               (int uid)           { return M[ H  ][ ¢+uid ]; }
                public int     tin                 (int uid)           { return M[ Ti ][ ¢+uid ]; }
                public int     tex                 (int uid)           { return M[ Tχ ][ ¢+uid ]; }
                public int     low                 (int uid)           { return M[ L  ][ ¢+uid ]; }
                public int     root                (int uid)           { return M[ δ  ][ ¢+uid ]; }
                public int     cid                 (int uid)           { return M[ I  ][ ¢+uid ]; }
                public int     rank                (int uid)           { return M[ K  ][ ¢+uid ]; }
                public void    set_pe              (int uid, int pe)   {        M[ ϵ  ][ ¢+uid ]  =    pe;                }
                public void    set_low             (int uid, int low)  {        M[ L  ][ ¢+uid ]  =   low;                }
                public void    set_score           (int uid, int score){        M[ £  ][ ¢+uid ]  = score;                }

                public void set_tin_and_low(int uid, int time) {
                    M[ at ][ ¢+time ] = uid;
                    M[ Ti ][ ¢+uid  ] = time;
                    M[ L  ][ ¢+uid  ] = time;
                }
                public void  set_pv(int uid, int pv) {
                    M[ π  ][ ¢+uid ]  = pv;
                    M[ H  ][ ¢+uid ]  = pv == NONE ? 0   : M[ H  ][ ¢+pv ] + 1;
                    M[ δ  ][ ¢+uid ]  = pv == NONE ? uid : M[ δ  ][ ¢+pv ];
                }
                public void set_rank_and_cid(int uid, int rank, int cid) {
                    M[ Ω  ][ ¢+rank ] = uid;
                    M[ K  ][ ¢+uid  ] = rank;
                    M[ I  ][ ¢+uid  ] = cid;
                    if(is_leader(uid)) {
                        M[ F  ][ ¢+cid ] = rank;
                    }
                }
                public void set_tex_and_update_low(int uid, int time) {
                    M[ Tχ ][ ¢+uid ]  = time;
                    if(!is_leader(uid)) {
                        var pv = pv(uid);
                        set_low(pv, mini(low(pv), low(uid)));
                    }
                }
            };
        }
    }

    interface State {
        int time();
        int rank();
        int cid();
        int uid();
        int depth();
        boolean is_stopped();
        boolean is_started();
        boolean enter(long frontier_state);
        void exit (long frontier_state);

        static State of(Memory memory, IIC on_enter, IIIIC on_exit) {
            return new State() {
                int time = 0, rank = 0, cid = 0, uid = NONE;
                boolean is_stopped = false;

                public int time()                     { return time;  }
                public int rank()                     { return rank;  }
                public int cid()                      { return cid;   }
                public int uid()                      { return uid;   }
                public int depth()                    { return uid == NONE ? 0 : memory.depth(uid); }
                public boolean is_started()           { return time != 0; }
                public boolean is_stopped()           { return is_stopped; }
                public boolean enter(long frontier_state)   {
                    on_enter.accept(this.uid = entry_13925031.uid(frontier_state), this.time++);
                    return !(is_stopped |= memory.is_target(this.uid));
                }
                public void exit (long frontier_state) {
                    on_exit .accept(this.uid = entry_13925031.uid(frontier_state), this.time, this.rank++, this.cid);
                    cid += memory.is_leader(this.uid) ? 1:0;
                }
            };
        }
    }

    interface PartialVisitor {
        boolean visit_edge(int it, int pe, int pv, int uid, int alt);
        void    enter_node(int uid, int time);
        void    exit_node (int uid, int time, int rank, int cid);

        static PartialVisitor of(Graph G, int options, Relaxer relaxer, Visitor visitor, Memory memory) {
            return new PartialVisitor() {
                @Override public void enter_node(int uid, int time) {
                    memory.set_tin_and_low(uid, time);
                    visitor.enter(uid);
                }
                @Override public boolean visit_edge(int it, int pe, int pv, int vid, int alt) {
                    if(update_pre_test(options)) {
                        memory.set_score(vid, alt);
                    }
                    memory.set_reached(vid);
                    if(relaxer.test(alt, memory.score(vid))) {
                        if(pv == NONE || visitor.tree(it, pe, pv, vid, alt)) {
                            memory.set_pe(vid, pe);
                            memory.set_pv(vid, pv);
                            memory.set_score(vid, alt);
                            return pv == NONE ? visitor.leader(vid, alt) : visitor.follower(it, pe, pv, vid, alt);
                        }
                    } else if(pv != NONE) {
                        if(!G.is_directed()) {
                            if(memory.pv(pv) == vid || memory.pe(pv) == pe) {
                                visitor.parent(it, pe, pv, vid, alt);
                            } else {
                                memory.set_low(pv, mini(memory.low(pv), memory.tin(vid)));
                                visitor.back(it, pe, pv, vid, alt);
                            }
                        } else {
                            if(memory.tex(vid) != NONE && memory.tin(pv) < memory.tin(vid)) {
                                visitor.forward(it, pe, pv, vid, alt);
                            } else if(memory.tex(vid) != NONE && memory.tin(pv) > memory.tin(vid)) {
                                visitor.cross(it, pe, pv, vid, alt);
                            } else {
                                visitor.back(it, pe, pv, vid, alt);
                            }
                        }
                    }
                    return false;
                }
                @Override public void exit_node(int uid, int time, int rank, int cid) {
                    memory.set_tex_and_update_low(uid, time);
                    memory.set_rank_and_cid(uid, rank, cid);
                    visitor.exit(uid);
                }
            };
        }
    }
    static class Readers {
        static Reader<Walk.Context, Memory> memory() {
            return Reader.of((B) -> {
                var memory = Memory.of(B.G);
                B.G.node_ids().forEach((uid) -> memory.set_score(uid, B.initializer.apply(uid)));
                B.target.forEach(memory::set_target);
                return memory;
            });
        }
        static Reader<Walk.Context, Frontier> frontier(Memory memory)  {
            return Reader.of((B) -> Frontier.of(B.G, B.options, (uid, vid) -> {
                if(uid == NONE) return vid;
                if(vid == NONE) return uid;
                var score1 = memory.score(uid);
                var score2 = memory.score(vid);
                return B.combiner.apply(score1, score2) == score1 ? uid : vid;
            }));
        }
        static Reader<Walk.Context, PartialVisitor> partial     (Memory memory)                         { return Reader.of((B) -> PartialVisitor.of(B.G, B.options, B.relaxer, B.visitor, memory)); }
        static Reader<Walk.Context, State>          state       (Memory memory, PartialVisitor partial) { return Reader.of((__) -> State.of(memory, partial::enter_node, partial::exit_node)); }
        static Reader<Walk.Context, NextFunction>   next        (Memory memory, State state)            { // TODO: this needs to be corrected
            return Reader.of((B) -> B.edge_value
                 .map((edge_value) -> B.virtualizer
                   .map((virtualizer) -> NextFunction.of(B.G, B.options, edge_value, memory, state, virtualizer))
                   .orElseGet(() -> {
                       if(frontier_factory_type(B.options) == Flags.HEAP) {
                           return NextFunction.of(B.G, B.options, edge_value, memory, state, (_state, j, u, v, z, du, w, D) -> D.push(0, w));
                       } else {
                           return NextFunction.of(B.G, B.options, edge_value);
                       }
                   })
                 )
                 .orElseGet(() -> NextFunction.of(B.G, B.options))
            );
        }
        static Reader<Walk.Context, Replay> replay() {
            return Reader.of((B) -> {
                var memory   = Readers.memory().run(B);
                var partial  = Readers.partial(memory).run(B);
                var state    = Readers.state(memory, partial).run(B);
                var next     = Readers.next(memory, state).run(B);
                var edge_to_weight_fn = Readers.edge_to_weight_fn(memory, state).run(B);
                var frontier = Readers.frontier(memory).run(B);
                B.source.forEach((vid) -> {
                    if(partial.visit_edge(NONE, NONE, NONE, vid, B.node_value.apply(state, vid))) {
                        frontier.push(vid);
                        if(single_source(B.options)) {
                            entry_13925031.Walks.exhaust(next, edge_to_weight_fn, frontier, state, partial);
                        }
                    }
                });
                entry_13925031.Walks.exhaust(next, edge_to_weight_fn, frontier, state, partial);
                return Replay.of(B.G, memory, state);
            });
        }
        static Reader<Walk.Context, EdgeToWeightFunction> edge_to_weight_fn(Memory memory, State state) {
            return Reader.of((B) -> EdgeToWeightFunction.of(B.node_value, B.extender, memory, state));
        }
    }

    static class Walks {
        static void exhaust(NextFunction next, EdgeToWeightFunction weight, Frontier frontier, State state, PartialVisitor visitor) {
            while(!frontier.isEmpty()) {
                var node = frontier.peek();
                if(is_first_out(node) && !state.enter(node)) {
                    return;
                }
                next.apply(node, (it, pe, pv, vid, w) -> {
                    var alt = weight.apply(it, pe, pv, vid, w);
                    if(visitor.visit_edge(it, pe, pv, vid, alt)) {
                        frontier.push(vid);
                    }
                });
                if(is_last_out(node)) {
                    state.exit(node);
                }
            }
        }
    }

    interface Frontier extends LongView {
        enum Memory {
            INSTANCE;
            long [] Q = new long [N];
        }
        void    push            (int uid);
        long    peek            ();

        static Frontier stack(Graph G, Combiner __) {
            var Q = Memory.INSTANCE.Q;
            return new Frontier() {
                int tail = 0;
                public int size()                 { return tail; }
                public long get(int i)            { return Q[ i ]; }
                public void push(int uid)         {
                    var it = G.degree(uid);
                    if(it == 0) {
                        Q[ tail++ ] = encode(uid, 0, 0, 1, 1);
                    } else {
                        Q[ tail++ ] = encode(uid, it, it-1, 1, 0);
                    }
                }
                public long peek() {
                    var state = Q[ tail-1 ];
                    if(is_last_out(state)) {
                        tail--;
                    } else {
                        var uid   = uid(state);
                        var stop  = stop(state);
                        if(stop-1 < 0) {
                            Q[ tail-1 ] = encode(uid, 0, 0, 0, 1);
                        } else {
                            Q[ tail-1 ] = encode(uid, stop, stop-1, 0, 0);
                        }
                    }
                    return state;
                }
            };
        }
        static Frontier queue(Graph G, Combiner __) {
            var Q = Memory.INSTANCE.Q;
            return new Frontier() {
                int head = 0, tail = 0;
                public int size()              { return tail - head; }
                public long get(int i)         { return Q[ head+i ]; }
                public void push(int uid)      {
                    var it = G.degree(uid) - 1;
                    Q[ tail++ ] = encode(uid, it < 0 ? 0 : it, 0, 1, 1);
                }
                public long peek()             { return Q[ head++ ]; }
            };
        }
        static Frontier heap(Graph G, Combiner combine_node_ids) {
            var n = gon[G.id() + 1] - gon[G.id()] - 1;
            var Q = Memory.INSTANCE.Q;
            Arrays.fill(Q, 0, n + n, NONE);
            return new Frontier() {
                int size = 0;

                public int size()              { return size; }
                public long get(int i)         { throw new IllegalStateException(); }
                public void push(int uid) {
                    size += Q[ uid+n ] == NONE ? 1 : 0;
                    update(uid, uid);
                }
                public long peek() {
                    var uid = this.query();
                    size--;
                    update(uid, NONE);
                    var it = G.degree(uid) - 1;
                    return encode(uid, it < 0 ? 0 : it, 0, 1, 1);
                }
                private int query() {
                    int l = 1, r = n+1;
                    var argmin = NONE;
                    for(l += n, r += n + 1; l < r; l >>= 1, r >>= 1) {
                        if ((l % 2) == 1) { argmin = combine_node_ids.apply((int) Q[l++], argmin); }
                        if ((r % 2) == 1) { argmin = combine_node_ids.apply((int) Q[--r], argmin); }
                    }
                    return argmin;
                }
                private void update(int uid, int x) {
                    Q[ uid+n ] = x;
                    for(var i = (uid + n); i > 1; i >>= 1) {
                        Q[i >> 1] = combine_node_ids.apply((int) Q[i], (int) Q[i ^ 1]);
                    }
                }
            };
        }
        static Frontier of(Graph G, int options, Combiner combiner) {
            var type = frontier_factory_type(options);
            if(type == Flags.STACK) {
                return Frontier.stack(G, combiner);
            } else if(type == Flags.QUEUE) {
                return Frontier.queue(G, combiner);
            } else if(type == Flags.HEAP) {
                return Frontier.heap(G, combiner);
            }
            throw new IllegalStateException();
        }
        static long encode(long uid, long start, long stop, long is_first_out, long is_last_out) { return (uid << 42) | (start << 22) | (stop << 2) | (is_last_out << 1) | is_first_out; }
    }

    static class Masks {
        static final long IS_FIRST_OUT = 0b01;
        static final long IS_LAST_OUT  = 0x02L;
        static final long STOP         = 0x3FFFFCL;
        static final long START        = 0x3FFFFC00000L;
        static final long UID          = 0x3FFFFC0000000000L;
    }
    static boolean has(int set, int a) { return (set & a) == a; }
    static boolean single_source        (int options)       { return  has(options, Flags.SINGLE_SOURCE);        }
    static boolean extend_self          (int options)       { return  has(options, Flags.EXTEND_SELF);          }
    static boolean update_pre_test      (int options)       { return  has(options, Flags.UPDATE_PRE_TEST);      }
    static boolean backtrack_post_exit  (int options)       { return  has(options, Flags.BACKTRACK_POST_EXIT);  }
    static boolean is_reversed          (int options)       { return  has(options, Flags.IS_REVERSED);          }
    static int     frontier_factory_type(int options)       { return (options & (Flags.STACK | Flags.QUEUE | Flags.HEAP)); }
    static boolean is_first_out (long frontier_state) { return       (frontier_state & Masks.IS_FIRST_OUT) != 0; }
    static boolean is_last_out  (long frontier_state) { return       (frontier_state & Masks.IS_LAST_OUT ) != 0; }
    static int     stop         (long frontier_state) { return (int) ((frontier_state & Masks.STOP  ) >>>  2); }
    static int     start        (long frontier_state) { return (int) ((frontier_state & Masks.START ) >>> 22); }
    static int     uid          (long frontier_state) { return (int) ((frontier_state & Masks.UID   ) >>> 42); }

    interface NodeValue     { int       apply   (State  ctx    , int uid   ); }
    interface EdgeValue     { int       apply   (int    inidx              ); } // TODO: -> (State state, int inidx)
    interface Extender      { int       apply   (int    score  , int w     ); }
    interface Combiner      { int       apply   (int    score1 , int score2); }
    interface Relaxer       { boolean   test    (int    alt    , int best  ); }
    interface Initializer   { int       apply   (int    uid                ); }

    interface Node {
        int uid();
        Adjacency outgoing();
        default Adjacency incoming() { return outgoing(); }
        default int indegree ()      { return incoming().size(); }
        default int outdegree()      { return outgoing().size(); }
    }
    interface Adjacency extends IntView {
        int size();
        int get(int i);
        default int inidx(int i) { throw new IllegalStateException(); }

        default void forEach(int start, int stop, IIIC downstream) {
            if(start < stop) {
                for(var it = maxi(0, start); it < mini(stop, size()); it++) {
                    var i = inidx(it);
                    var vid = get(it);
                    if(vid >= 0) {
                        downstream.accept(it, i, vid);
                    }
                }
            } else {
                var lo = mini(start, size()-1);
                var hi = maxi(0, stop);
                for(var it = lo; it >= hi; it--) {
                    var vid = get(it);
                    if(vid >= 0) {
                        downstream.accept(it, inidx(it), vid);
                    }
                }
            }
        }
    }
    static class Flags {
        static final int SINGLE_SOURCE          = 0b000000001;
        static final int EXTEND_SELF            = 0b000000010;
        static final int UPDATE_PRE_TEST        = 0b000000100;
        static final int BACKTRACK_POST_EXIT    = 0b000001000;
        static final int IS_REVERSED            = 0b000010000;
        static final int STACK                  = 0b000100000;
        static final int QUEUE                  = 0b001000000;
        static final int HEAP                   = 0b010000000;
    }

    interface EdgePredicate        { boolean   test(int it, int i, int uid, int vid, int alt);  }
    interface EdgeConsumer         { void      push(int it, int i, int uid, int vid, int w);  }
    interface EdgeToWeightFunction {
        int apply(int it, int i, int uid, int vid, int alt);

        static EdgeToWeightFunction of(NodeValue node_value, Extender extender, Memory memory, State ctx) {
            return (it, i, pv, vid, w) -> extender.apply(!memory.is_reached(pv) ? node_value.apply(ctx, pv) : memory.score(pv), w);
        }
    }
    interface NextFunction {
        void apply(long frontier_state, EdgeConsumer downstream);

        static NextFunction of(Graph G, int options) {
            return (frontier_state, downstream) -> { // TODO: delete this?
                var uid = uid(frontier_state);
                var next = is_reversed(options) ? G.incoming(uid) : G.outgoing(uid);
                next.forEach(start(frontier_state), stop(frontier_state), (it, i, vid) -> {
                    if(vid != NONE) {
                        downstream.push(it, i, uid, vid, +1);
                    }
                });
            };
        }
        static NextFunction of(Graph G, int options, EdgeValue edge_value) { // TODO: this needs to be fixed
            return (frontier_state, downstream) -> {
                var uid = uid(frontier_state);
                var next = is_reversed(options) ? G.incoming(uid) : G.outgoing(uid);
                next.forEach(start(frontier_state), stop(frontier_state), (it, i, vid) -> {
                    if(vid != NONE) {
                        var w = edge_value.apply(i);
                        downstream.push(it, i, uid, vid, w);
                    }
                });
            };
        }
        static NextFunction of(Graph G, int options, EdgeValue edge_value, Memory memory, State state, Virtualizer virtualizer) {
            return (frontier_state, downstream) -> {
                var uid = uid(frontier_state);
                var k = G.k();
                var u = G.x(uid);
                var z = G.z(uid);
                var next = is_reversed(options) ? G.incoming(uid) : G.outgoing(uid);
                next.forEach(start(frontier_state), stop(frontier_state), (it, i, vid) -> {
                    if(vid != NONE) {
                        var v = G.x(vid);
                        var w = edge_value.apply(i);
                        virtualizer.apply(state, i, u, v, z, memory.score(uid), w, (dz, nw) -> {
                            var nz = G.z(uid) + dz;
                            if(ini(nz, 0, k)) {
                                var nvid = G.uid(nz, v);
                                var pv   = extend_self(options) ? nvid : uid;
                                downstream.push(it, i, pv, nvid, nw);
                            }
                        });
                    }
                });
            };
        }
    }

    interface EdgeSeq {
        void forEach(EdgeConsumer downstream);

        default EdgeSeq filter(EdgePredicate P) {
            return (downstream) -> {
                forEach((it, i, uid, vid, alt) -> {
                    if(P.test(it, i, uid, vid, alt)) {
                        downstream.push(it, i, uid, vid, alt);
                    }
                });
            };
        }
        default EdgeSeq filter(EdgePredicate P, EdgeConsumer downstream_on_failure) {
            return (downstream_on_success) -> {
                forEach((it, i, uid, vid, alt) -> {
                    if(P.test(it, i, uid, vid, alt)) {
                        downstream_on_success.push(it, i, uid, vid, alt);
                    } else {
                        downstream_on_failure.push(it, i, uid, vid, alt);
                    }
                });
            };
        }
        default EdgeSeq map_weight(EdgeToWeightFunction f) {
            return (downstream) -> {
                forEach((it, i, uid, vid, w) -> {
                    var alt = f.apply(it, i, uid, vid, w);
                    downstream.push(it, i, uid, vid, alt);
                });
            };
        }
    }

    interface Virtualizer {
        interface Downstream {
            void push(int dz, int w);
        }
        void apply(State state, int i, int u, int v, int z, int du, int w, Downstream downstream);

        interface GridAdapter {
            void push(State state, int y, int x, int ny, int nx, int z, int du, int w, Downstream downstream);
        }
        static Virtualizer of(int C     , Virtualizer.GridAdapter adapter) { return (state, j, u, v, z, du, w, D) -> adapter.push(state, u/C, u%C, v/C, v%C, z, du, w, D); }
        static Virtualizer of(int [][] A, Virtualizer.GridAdapter adapter) { return Virtualizer.of(A[0].length, adapter); }
        static Virtualizer of(char[][] A, Virtualizer.GridAdapter adapter) { return Virtualizer.of(A[0].length, adapter); }
    }

    interface Graph {
        int id();
        View<Node>  nodes();
        int         node_value(int uid);
        int         edge_value(int j);
        default boolean     is_reversed     ()                                                  { return false; }
        default boolean     is_directed     ()                                                  { return false; }
        default int         k               ()                                                  { return 1; }
        default int         n               ()                                                  { return nodes().size(); }
        default int         uid             (int z, int x)                                      { return n() * z + x; }
        default int         x               (int uid)                                           { return uid % n(); }
        default int         z               (int uid)                                           { return uid / n(); }
        default int         indegree        (int uid)                                           { return nodes().get(uid).incoming().size(); }
        default int         outdegree       (int uid)                                           { return nodes().get(uid).outgoing().size(); }
        default Adjacency   incoming        (int uid)                                           { return nodes().get(uid).incoming(); }
        default Adjacency   outgoing        (int uid)                                           { return nodes().get(uid).outgoing(); }
        default IntView     node_ids        ()                                                  { return nodes().mappedToInt(Node::uid); }
        default IntView     node_ids        (IP P)                                              { return nodes().mappedToInt(Node::uid).filtered(P); }
        default int         degree          (int uid)                                           { return is_reversed() ? indegree(uid) : outdegree(uid); }
        default Adjacency   next            (int uid)                                           { return is_reversed() ? incoming(uid) : outgoing(uid);  }
        default void        next            (int uid, int start, int stop, IIIIIC downstream)   { next(uid).forEach(start, stop, (it, i, vid) -> downstream.accept(it, i, uid, vid, this.edge_value(i))); }

        default boolean test(int uid, CellPredicate P)  { throw new IllegalStateException(); } // TODO 1. Builder<GRAPH extends Graph, T>, 2. delete this

        default Walk.Context depth_first     ()                   { return Walk.depth_first(this).source((__) -> true); }
        default Walk.Context depth_first     (int src)            { return Walk.depth_first(this).source(src); }
        default Walk.Context breadth_first   (int src)            { return Walk.breadth_first(this).source(src); }
        default Walk.Context dijkstras       (int src)            { return Walk.dijkstras(this).source(src); }
        default Walk.Context dijkstras       (int src, int dst)   { return Walk.dijkstras(this).source(src).target(IntView.of(0, k(), (z) -> uid(z, dst))); }
        default Walk.Context kahns           ()                   { return Walk.kahns(this).source((uid) -> this.indegree(uid) == 0); }
        default Seq<Integer> bridges() {
            var replay = depth_first().call();
            return (downstream) -> node_ids()
                .filter(replay::is_follower)
                .filter((uid) -> replay.low(uid) == replay.tin(uid))
                .map(replay::pe)
                .forEach(downstream::push);
        }

        interface Builder {
            interface Upstream {
                void push(int i, int u, int v, Builder self);
            }
            Builder add(int u, int v);
        }
    }
    static class Walk {
        static Context depth_first(Graph G) {
            return Context.of(G)
                          .options(Flags.STACK | Flags.SINGLE_SOURCE)
                          .initializer((__) -> IntID.NONE)
                          .node_value((ctx, __) -> ctx.time())
                          //   .edge_value((i) -> NONE)
                          .extender((score, __) -> score)
                          .relaxer((__, best) -> best == NONE);
        }
        static Context breadth_first(Graph G) {
            return Context.of(G)
                          .options(Flags.QUEUE)
                          .initializer((__) -> IntID.MAX)
                          .node_value((ctx, __) -> ctx.depth())
                          //   .edge_value((i) -> +1)
                          .extender((score, w) -> score + w)
                          .relaxer((alt, best) -> alt < best);
        }
        static Context dijkstras(Graph G) {
            return Context.of(G)
                          .options(Flags.HEAP)
                          .initializer((__) -> IntID.MAX)
                          .node_value((__, uid) -> G.node_value(uid))
                          .edge_value((i) -> G.edge_value(i))
                          .extender((score, w) -> score + w)
                          .combiner((score1, score2) -> Integer.min(score1, score2))
                          .relaxer((alt, best) -> alt < best);
        }
        static Context kahns(Graph G) {  // TODO: abstract to both directions
            return Context.of(G)
                          .options(Flags.QUEUE | Flags.UPDATE_PRE_TEST | Flags.EXTEND_SELF)
                          .virtualizer((state, j, u, v, z, du, w, D) -> D.push(0, w))         // TODO: once next function factory is fixed, get rid of this
                          .initializer((__) -> NONE)
                          .node_value((ctx, uid) -> G.indegree(uid))
                          .edge_value((__) -> -1)
                          .extender((score, w) -> score + w)
                          .relaxer((alt, __) -> alt == 0);
        }

        static class Context implements Callable<Replay> {
            Graph G;
            int options;
            NodeValue node_value;
            Optional<EdgeValue> edge_value;
            Initializer initializer;
            Extender extender;
            Combiner combiner;
            Relaxer relaxer;
            Optional<Virtualizer> virtualizer;
            Visitor visitor;
            IntSeq source;
            IntSeq target;

            Context(Graph G, int options, NodeValue node_value, Optional<EdgeValue> edge_value, Initializer initializer, Extender extender, Combiner combiner, Relaxer relaxer, Optional<Virtualizer> virtualizer, Visitor visitor, IntSeq source, IntSeq target) {
                this.G = G;
                this.options = options;
                this.node_value = node_value;
                this.edge_value = edge_value;
                this.initializer = initializer;
                this.extender = extender;
                this.combiner = combiner;
                this.relaxer = relaxer;
                this.virtualizer = virtualizer;
                this.visitor = visitor;
                this.source = source;
                this.target = target;
            }
            public Context options         (int           x)             { return new Context(G, x      , node_value, edge_value, initializer, extender, combiner, relaxer, virtualizer, visitor, source, target); }
            public Context node_value      (NodeValue     x)             { return new Context(G, options, x         , edge_value, initializer, extender, combiner, relaxer, virtualizer, visitor, source, target); }
            public Context edge_value      (Optional<EdgeValue>     x)   { return new Context(G, options, node_value, x         , initializer, extender, combiner, relaxer, virtualizer, visitor, source, target); }
            public Context initializer     (Initializer   x)             { return new Context(G, options, node_value, edge_value, x          , extender, combiner, relaxer, virtualizer, visitor, source, target); }
            public Context extender        (Extender      x)             { return new Context(G, options, node_value, edge_value, initializer, x       , combiner, relaxer, virtualizer, visitor, source, target); }
            public Context combiner        (Combiner      x)             { return new Context(G, options, node_value, edge_value, initializer, extender, x       , relaxer, virtualizer, visitor, source, target); }
            public Context relaxer         (Relaxer       x)             { return new Context(G, options, node_value, edge_value, initializer, extender, combiner, x      , virtualizer, visitor, source, target); }
            public Context virtualizer     (Optional<Virtualizer>   x)   { return new Context(G, options, node_value, edge_value, initializer, extender, combiner, relaxer, x          , visitor, source, target); }
            public Context visitor         (Visitor       x)             { return new Context(G, options, node_value, edge_value, initializer, extender, combiner, relaxer, virtualizer, x      , source, target); }
            public Context source          (IntSeq        x)             { return new Context(G, options, node_value, edge_value, initializer, extender, combiner, relaxer, virtualizer, visitor, x     , target); }
            public Context target          (IntSeq        x)             { return new Context(G, options, node_value, edge_value, initializer, extender, combiner, relaxer, virtualizer, visitor, source, x     ); }

            public Context source(int x)     { return this.source(IntSeq.of(x)); }
            public Context source(IP P)      { return this.source(IntSeq.of(G.node_ids(P))); }
            public Context target(int x)     { return this.target(IntSeq.of(x)); }
            public Context target(IntView x) { return this.target(IntSeq.of(x)); }
            public Context edge_value(EdgeValue edge_value)      { return this.edge_value(Optional.of(edge_value)); }
            public Context virtualizer(Virtualizer virtualizer)                     { return this.virtualizer(Optional.of(virtualizer));   }
            public Context virtualizer(int [][] A, Virtualizer.GridAdapter adapter) { return this.virtualizer(Virtualizer.of(A, adapter)); }
            public Context virtualizer(char[][] A, Virtualizer.GridAdapter adapter) { return this.virtualizer(Virtualizer.of(A, adapter)); }

            public Replay call() {
                Assert.that( source != null );
                return Readers.replay().run(this);
            }
            static Context of(Graph G) {
                return new Context(G,
                   Default.options(),
                   Default.node_value(), Default.edge_value(),
                   Default.initializer(), Default.extender(), Default.combiner(), Default.relaxer(),
                   Default.virtualizer(),
                   Default.visitor(),
                   Default.source(), Default.target()
                );
            }
            static class Default {
                static int       options()                 { return 0; }
                static NodeValue node_value()              { return (ctx, uid) ->  0; }
                static Optional<EdgeValue> edge_value()    { return Optional.empty(); }
                static Initializer initializer()           { return (uid) -> NONE; }
                static Extender extender()                 { return (score, w) -> score + w; }
                static Combiner combiner()                 { return (score1, score2) -> { throw new IllegalStateException(); }; }
                static Relaxer relaxer()                   { return (alt, best) -> alt < best; }
                static Optional<Virtualizer> virtualizer() { return Optional.empty(); } // (j, u, v, z, w, D) -> D.push(0, w)
                static Visitor visitor()                   { return Visitors.empty(); }
                static IntSeq source()                     { return null; }
                static IntSeq target()                     { return IntSeq.of(); }
            }
        }
    }
    interface Grid extends Graph {
        int R();
        int C();
        default int n()                                                          { return R() * C(); }
        default int row(int uid)                                                 { return uid / C(); }
        default int col(int uid)                                                 { return uid % C(); }
        default int rank(int row, int col)                                       { return row * C() + col; }
        default int top_left       ()                                            { return 0;                                                            }
        default int bottom_right   ()                                            { return (R()-1)*C() + (C()-1);                                        }
        default boolean is_boundary(Node node)                                   { return is_boundary(node.uid());                                      }
        default boolean is_boundary(int uid)                                     { return row(uid) == 0 || col(uid) == 0 || row(uid) == R()-1 || col(uid) == C()-1; }
        default boolean test       (int uid, CellPredicate predicate)            { return predicate.test  (uid / C(), uid % C());                       }
        default boolean test       (int uid, int vid, BiCellPredicate predicate) { return predicate.test  (uid / C(), uid % C(), vid / C(), vid % C()); }
        default void    accept     (Node node, IIC downstream)                   {        downstream.accept(node.uid() / C(), node.uid() % C());        }
        default void    accept     (int  uid , IIC downstream)                   {        downstream.accept(     uid   / C(),      uid   % C());        }
        default <R> R apply  (int  uid , BiFunction<Integer, Integer, R> mapper) { return mapper.apply(uid / C(), uid % C()); }
        default IntView node_by_id (CellPredicate node_predicate)                { return node_ids((uid) -> test(uid, node_predicate)); }

        static Grid of(char[][] A, Predicate<Character> predicate)          { return Grid.of(A.length, A[0].length, 1, Dirs.FOUR, BiCellPredicate.NOOP, (y, x) -> predicate.test(A[y][x])); }
        static Grid of( int[][] A)                                          { return Grid.of(A.length, A[0].length, 1, Dirs.FOUR, BiCellPredicate.NOOP, CellPredicate.NOOP); }
        static Grid of( int[][] A, IntEq ord)                               { return Grid.of(A.length, A[0].length, 1, Dirs.FOUR, BiCellPredicate.of(A, ord)); }
        static Grid of(char[][] A, IntEq ord)                               { return Grid.of(A.length, A[0].length, 1, Dirs.FOUR, BiCellPredicate.of(A, ord)); }
        static Grid of (int[][] A, IntBinaryOperator adapted_wv_getter)     { return Grid.of(A.length, A[0].length, 1, Dirs.FOUR, BiCellPredicate.NOOP, CellPredicate.NOOP, (j) -> 0, (uid) -> adapted_wv_getter.applyAsInt(uid/A[0].length, uid%A[0].length)); }
        static Grid of (int[][] A, BiCellPredicate edge_predicate)          { return Grid.of(A.length, A[0].length, 1, Dirs.FOUR, edge_predicate, CellPredicate.NOOP); }
        static Grid of (char[][] A, BiCellPredicate edge_predicate)         { return Grid.of(A.length, A[0].length, 1, Dirs.FOUR, edge_predicate, CellPredicate.NOOP); }
        static Grid of (int[][] A, int k)                                   { return Grid.of(A.length, A[0].length, k, Dirs.FOUR, BiCellPredicate.NOOP, CellPredicate.NOOP); }

        static Grid of(int R, int C)                                                                                        { return Grid.of(R, C, 1); }
        static Grid of(int R, int C, int k)                                                                                 { return Grid.of(R, C, k, Dirs.FOUR); }
        static Grid of(int R, int C, int k, Dirs directions)                                                                { return Grid.of(R, C, k, directions, BiCellPredicate.NOOP); }
        static Grid of(int R, int C, int k, Dirs directions, BiCellPredicate edge_predicate)                                { return Grid.of(R, C, k, directions, edge_predicate, CellPredicate.NOOP); }
        static Grid of(int R, int C, int k, Dirs directions, BiCellPredicate edge_predicate, CellPredicate node_predicate)  { return Grid.of(R, C, k, directions, edge_predicate, node_predicate, (__) -> 1, (__) -> 0); }

        static Grid of(int R, int C, int k, Dirs _directions, BiCellPredicate edge_predicate, CellPredicate node_predicate, IntUnaryOperator we_getter, IntUnaryOperator wv_getter) { // Allocated
            var directions = _directions.directions();
            var n = R*C;
            reset(n*k+1, 4*n + n);
            var B = CSR.Builder.of(n, k, false, we_getter, wv_getter);
            for(var u = 0; u < n; u++) {
                var y = u / C;
                var x = u % C;
                for(var d: directions) {
                    var ny = y + d[0];
                    var nx = x + d[1];
                    if(ini(ny, 0, R) && ini(nx, 0, C)) {
                        if(!node_predicate.test(ny, nx))       continue;
                        if(!edge_predicate.test(y, x, ny, nx)) continue;
                        B.add(u, ny*C + nx);
                    }
                }
            }
            var G = B.build();
            return new Grid() {
                public int R()                    { return R;                 }
                public int C()                    { return C;                 }
                public int k()                    { return G.k();             }
                public int id()                   { return G.id();            }
                public View<Node> nodes()         { return G.nodes();         }
                public int node_value(int u    )  { return wv_getter.applyAsInt(u);        }
                public int edge_value(int inidx)  { return we_getter.applyAsInt(inidx);    }
                public int rank(int row, int col) { return row * C + col;  }
            };
        }
        static Grid of(int R, int C, IntUnaryOperator we_getter, IntUnaryOperator wv_getter, Dirs _directions) { // Virtual
            var directions = _directions.directions();
            // reset();
            gon[1] = R*C + 1;
            return new Grid() {
                public int id() { return 0; }
                public int R()  { return R; }
                public int C()  { return C; }
                public int node_value(int uid) { return wv_getter.applyAsInt(uid); }
                public int edge_value(int i)   { return we_getter.applyAsInt(i);   }
                public View<Node> nodes() {
                    return new View<>() {
                        public int size() { return R * C; }
                        public Node get(int uid) {
                            return new Node() {
                                public int uid() { return uid; }
                                public Adjacency outgoing() {
                                    return new Adjacency() { // tighten this up, (the four corners have 2 neighbors, the rest on the boundary have 3, everyone else has 4
                                        public int size()       { return directions.length; }
                                        public int get(int i)   {
                                            var y = uid / C;
                                            var x = uid % C;
                                            var ny = y + directions[i][0];
                                            var nx = x + directions[i][1];
                                            return ny < 0 || nx < 0 || ny >= R || nx >= C ? NONE : ny*C + nx;
                                        }
                                        public int inidx(int i) { return directions.length * uid + i; }
                                    };
                                }
                            };
                        }
                    };
                }
            };
        }
    }
    interface CellPredicate extends IIP {
        CellPredicate NOOP = (y, x) -> true;

        static CellPredicate of( int[][] A, int  value, IntEq eq) { return (y, x) -> eq.test(A[y][x]    , value    ); }
        static CellPredicate of(char[][] A, char value, IntEq eq) { return (y, x) -> eq.test(A[y][x]-'0', value-'0'); }
    }
    interface BiCellPredicate extends IIIIP {
        BiCellPredicate NOOP = (y, x, ny, nx) -> true;

        static BiCellPredicate of( int[][] A, IntEq eq) { return (y, x, ny, nx) -> eq.test(A[y][x], A[ny][nx]); }
        static BiCellPredicate of(char[][] A, IntEq eq) { return (y, x, ny, nx) -> eq.test(A[y][x]-'0', A[ny][nx]-'0'); }
    }

    static class Visitors {
        static final Visitor empty() {
            return new Visitor() {};
        }
        static final Visitor debug(Graph G) {
            return new Visitor() {
                @Override public boolean leader (int uid, int alt)                   { out.printf("LEADER %2d                  \n", uid); return true; }
                @Override public void enter  (int uid)                               { out.printf("ENTER  %2d                  \n", uid);              }
                @Override public boolean tree   (int it, int i, int uid, int vid, int alt)   { out.printf("TREE   %2d -> %2d \t  D: %d \n", uid, vid, alt);                                                return true; }
                @Override public void    back   (int it, int i, int uid, int vid, int alt)   { out.printf("BACK   %2d -> %2d \t  D: %d \n", uid, vid, alt);                                                             }
                @Override public void    exit   (int uid)                            { out.printf("EXIT   %2d                  \n", uid          );                                                             }
            };
        }
    }
    interface WeaklyConnectedComponent extends IntView {
        int leader();
        static WeaklyConnectedComponent of(Map.Entry<Integer, List<Integer>> e) {
            return new WeaklyConnectedComponent() {
                public int size()       { return e.getValue().size(); }
                public int get(int i)   { return e.getValue().get(i); }
                public int leader()     { return e.getKey(); }
            };
        }
    }
    public int find(int[] root, int u) {
        return root[u] = (u == root[u] ? u : find(root, root[u]));
    }
    public View<WeaklyConnectedComponent> weakly_connected_component(Graph G) {
        var root = new int[ G.n() ];
        var size = new int[ G.n() ];
        Arrays.setAll(root, u -> u);
        Arrays.fill(size, 1);
        for(var u: G.node_ids()) {
            for(var v: G.outgoing(u)) {
                var pu = find(root, u);
                var pv = find(root, v);
                if(pu != pv) {
                    if(size[pu] > size[pv]) {
                        size[pu] += size[pv];
                        root[pv] = pu;
                    } else {
                        size[pv] += size[pu];
                        root[pu] = pv;
                    }
                }
            }
        }
        var entries = new ArrayList<>(G.node_ids()
                                       .map((uid) -> new int[] {uid, root[uid]})
                                       .collect(groupingBy((u_root) -> u_root[1], mapping((u_root) -> u_root[0], toList())))
                                       .entrySet());
        return new View<>() {
            public int size()                          { return entries.size(); }
            public WeaklyConnectedComponent get(int i) { return WeaklyConnectedComponent.of( entries.get(i) ); }
        };
    }

    enum Dirs {
        KNIGHT(new int[][] {{+2, 1},{ 1, 2},{-1, 2},{-2, 1},{-2,-1},{-1,-2},{ 1,-2},{ 2,-1}}),
        FOUR  (new int[][] {{+1, 0},{-1, 0},{ 0,-1},{ 0,+1}});

        final int[][] $dirs;
        Dirs(int[][] $dirs) {
            this.$dirs = $dirs;
        }
        public int[][] directions()                       { return $dirs; }
        public int size()                                 { return $dirs.length; }
        public int map(int R, int C, int uid, int i)             {
            var y = uid / C;
            var x = uid % C;
            var ny = y + $dirs[i][0];
            var nx = x + $dirs[i][1];
            // if(ny < 0 || nx < 0) {
            //     out.printf("uid: %d\tny: %d\tnx: %d\n", uid, ny, nx);
            // }
            return ny < 0 || nx < 0 || nx >= C || ny >= R ? NONE : ny*C + nx;
        }
        public void forEach(int y, int x, IIC downstream) {
            for(var dy_dx: $dirs) {
                downstream.accept(y+dy_dx[0], x+dy_dx[1]);
            }
        }
    }

    static long pair (int left, int right)      { return (((long) left) << Integer.SIZE) | right; }
    static int  left (long pair)                { return   (int)  (pair >> Integer.SIZE);         }
    static int  right(long pair)                { return   (int)  (pair & 0xFFFF_FFFFL);          }
    static int  key  (long pair)                { return gon[ left( pair ) ] + right( pair );     }

    class Offset {
        static final int ZERO = 0;
        static final int ONE  = 1;
    }
    interface CSR extends Graph {
        static CSR   directed(int n0, int k, int[][] E, int ofs) { return CSR.of(n0, k, E, (i, u, v, builder) -> builder.add(u-ofs, v-ofs), true); }
        static CSR undirected(int n0, int k, int[][] E, int ofs) { return CSR.of(n0, k, E, (i, u, v, builder) -> builder.add(u-ofs, v-ofs).add(v-ofs, u-ofs), false); }
        static CSR of(int n, int k, int[][] E, Graph.Builder.Upstream upstream, boolean is_directed) {
            var N = n * k;
            var m = E.length * (is_directed ? 1 : 2);
            reset(N + 1, m + n);
            var B = Builder.of(n, k, is_directed, (j) -> E[j].length == 2 ? 1 : E[j][2]);
            for(var i = 0; i < E.length; i++) {
                upstream.push(i, E[i][0], E[i][1], B);
            }
            return B.build();
        }
        interface Builder extends Graph.Builder {
            CSR build();

            static Builder of(int n, int k, boolean is_directed)                                                         { return of(n, k, is_directed, (__) -> 1); }
            static Builder of(int n, int k, boolean is_directed, IntUnaryOperator we_getter)                             { return of(n, k, is_directed, we_getter, (__) -> 0); }
            static Builder of(int n, int k, boolean is_directed, IntUnaryOperator we_getter, IntUnaryOperator wv_getter) {
                var  N       = n * k;
                var n0       = n_ptr.get();
                var m0       = m_ptr.get();
                var  gid     = g_ptr.getAndIncrement();
                gon[ gid+1 ] = n_ptr.addAndGet( N+1 );
                goe[ gid ]   = m0;
                return new Builder() {
                    public Builder add(int u, int v) {
                        var mf = m_ptr.getAndIncrement();
                        ilo[ key(dst[mf] = pair(gid, v)) ]++;
                        olo[ key(src[mf] = pair(gid, u)) ]++;
                        return this;
                    }
                    public CSR build() {
                        var nf = n_ptr.get();
                        var mf = m_ptr.get();
                        Arrays.parallelPrefix(ilo, n0, nf+1, Integer::sum);
                        Arrays.parallelPrefix(olo, n0, nf+1, Integer::sum);
                        IntStream.range(m0, mf).forEach(j -> oref[--olo[ key(src[j]) ]] = j);
                        IntStream.range(m0, mf).forEach(j -> iref[--ilo[ key(dst[j]) ]] = j);
                        Arrays.fill(src, mf, mf+n, gon[gid] + N);                                 // todo: ilo[sentinel] = ?, olo[sentinel] = m1
                        IntStream.range(mf, mf+n).forEach(j -> dst[j] = pair(gid, j-mf));
                        goe[gid+1] = m_ptr.addAndGet(n);
                        return new CSR() {
                            public int id() { return gid; }
                            public int n()  { return n; }
                            public int m()  { return mf - m0; }
                            public int k()  { return k; }
                            public boolean is_directed() { return is_directed; }
                            public int node_value(int u    ) { return wv_getter.applyAsInt(u);        }
                            public int edge_value(int inidx) { return we_getter.applyAsInt(inidx);    }
                            public View<Node> nodes() {
                                return new View<>() {
                                    public int size() { return N; }
                                    public Node get(int uid) {
                                        var ß = gon[gid] + (uid % n);
                                        return new Node() {
                                            public int uid()    { return uid; }
                                            public int weight() { return wv_getter.applyAsInt(uid); }
                                            public Adjacency incoming() {
                                                return new Adjacency() {
                                                    public int   size()               { return ilo[ß+1] - ilo[ß];                }
                                                    public int  inidx(int i)          { return (iref[ ilo[ß]+i ] - goe[gid]) / (is_directed ? 1:2);     }
                                                    public int    get(int i)          { return right( src[iref[ ilo[ß]+i ]] );   }
                                                };
                                            }
                                            public Adjacency outgoing() {
                                                return new Adjacency() {
                                                    public int   size()               { return olo[ß+1] - olo[ß];                }
                                                    public int  inidx(int i)          { return (oref[ olo[ß]+i ] - goe[gid]) / (is_directed ? 1:2);     }
                                                    public int    get(int i)          { return right( dst[oref[ olo[ß]+i ]] );   }
                                                };
                                            }
                                        };
                                    }
                                };
                            }
                        };
                    }
                };
            }
        }
    }

    interface HasIntID {
        int id();
    }
    static final class IntID {
        static final int MIN     = Integer.MIN_VALUE;
        static final int ONE     = +1;
        static final int ZERO    =  0;
        static final int NONE    = -1;
        static final int MAX     = Integer.MAX_VALUE;
    }
    enum IntEq implements IIP {
        EQ  ((a, b) -> a == b),
        NEQ ((a, b) -> a != b);
        final IIP P;
        IntEq(IIP P) {
            this.P = P;
        }
        public boolean test(int a, int b) {
            return P.test(a, b);
        }
    }
    enum IntOrd implements IIP {
        LT   (Integer.MAX_VALUE, (a, b) -> a <  b),
        GT   (Integer.MIN_VALUE, (a, b) -> a >  b),
        FIRST(NONE             , (a, b) -> a == NONE),
        LAST (NONE             , (a, b) -> true);
        final int id;
        final IIP P;
        IntOrd(int id, IIP P) {
            this.id = id;
            this.P = P;
        }
        public boolean test(int a, int b) { return P.test(a, b); }
    }
    enum IntSemigroup implements IIF {
        MIN   ((a, b) -> a < b ? a : b),
        MAX   ((a, b) -> a > b ? a : b),
        FIRST ((a, b) -> a == NONE ? b : a),
        LAST  ((a, b) -> b),
        SUM   ((a, b) -> a + b),
        OR    ((a, b) -> a | b),
        AND   ((a, b) -> a & b);
        final IIF f;
        IntSemigroup(IIF f) {
            this.f = f;
        }
        public int apply(int a, int b) {
            return f.apply(a, b);
        }
    }
    interface IntMonoid extends HasIntID, IIF {
        default int apply(int[] A)             { return Arrays.stream(A).reduce(id(), this::apply); }
        default int apply(Iterable<Integer> A) { return StreamSupport.stream(A.spliterator(), false).reduce(id(), this::apply); }
        static IntMonoid of(IntSemigroup f, int id) {
            return new IntMonoid() {
                public int      id      ()                       { return id; }
                public int      apply   (int a, int b)           { return f.apply(a, b); }
            };
        }
        IntMonoid MIN        = IntMonoid.of(IntSemigroup.MIN   , IntID.MAX   );
        IntMonoid MAX        = IntMonoid.of(IntSemigroup.MAX   , IntID.MIN   );
        IntMonoid SUM        = IntMonoid.of(IntSemigroup.SUM   , IntID.ZERO  );
        IntMonoid OR         = IntMonoid.of(IntSemigroup.OR    , IntID.ZERO  );
        IntMonoid AND        = IntMonoid.of(IntSemigroup.AND   , IntID.ONE   );
        IntMonoid LAST       = IntMonoid.of(IntSemigroup.LAST  , IntID.NONE  );
    }
    interface IntSemiring {
        int     zero  ();
        int     one   ();
        int     times (int a, int b);
        int     plus  (int a, int b);
        default boolean test(int a, int b) {
            return this.plus(a, b) == a && a != b;
        }
        static IntSemiring of(IntMonoid monoid, IntOrd ord) {
            return new IntSemiring() {
                public int     zero ()             { return ord.id;             }
                public int     one  ()             { return monoid.id();        }
                public int     plus (int l, int r) { return l == zero() ? r      : r == zero() ? l      : ord   .test (l, r) ? l:r; }
                public int     times(int l, int r) { return l == zero() ? zero() : r == zero() ? zero() : monoid.apply(l, r)      ; }
                public boolean test (int l, int r) { return ord.test(l, r);     }
            };
        }
        IntSemiring MIN_PLUS     = IntSemiring.of(IntMonoid.SUM , IntOrd.LT);
        IntSemiring SINGLE_ENTRY = IntSemiring.of(IntMonoid.LAST, IntOrd.FIRST);
    }

    interface Path {
        IntView nodes();
        IntView edges();
        static Path of(IntView nodes, IntView edges) {
            return new Path() {
                public IntView nodes() { return nodes; }
                public IntView edges() { return edges; }
            };
        }
        static Path of(int gid, int j, int uid, int vid, IntView stack) {
            var du = Memory.Storage.INSTANCE.buf[ H  ][ gon[gid]+uid ];
            var dv = Memory.Storage.INSTANCE.buf[ H  ][ gon[gid]+vid ];
            int len = sizi(dv, du);
            var hi = stack.size();
            var lo = hi - len;
            return Path.of(
                stack.spliced(lo, hi).concated(vid),
                stack.spliced(lo, hi).mapped((_uid) -> Memory.Storage.INSTANCE.buf[ ϵ  ][ gon[gid]+_uid ])
            );
        }
    }
    interface Component extends View<Node> {
        int cid();
        default Node leader()                  { return get( size()-1 ); }
        default boolean is_trivial()           { return size() == 1; }
        default boolean is_complete()          { return stream().map(Node::outdegree).reduce(0, Integer::sum) == nc2l( size() ); }
        static Component of(Graph G, int cid, IntView members) {
            return new Component() {
                public int  cid()       { return cid; }
                public int  size()      { return members.size(); }
                public Node get(int i)  { return G.nodes().get(members.get(i)); }
            };
        }
    }
    interface ConnectedComponents extends View<Component> {
        static ConnectedComponents of(Graph G, IntView O, IntView F) {
            return new ConnectedComponents() {
                public int       size()     { return F.size(); }
                public Component get(int i) { return Component.of(G, i, O.spliced(i == 0 ? 0 : F.get(i-1) + 1, F.get(i) + 1)); }
            };
        }
    }
    interface Replay {
        boolean                       is_started            ();
        boolean                       is_stopped            ();
        boolean                       is_vertex_connected   ();
        boolean                       has_topological_order ();
        boolean                       reached_target        ();
        Optional<Integer>             reached_count         ();
        Optional<Integer>             terminus              ();
        Optional<Integer>             dist                  ();
        Optional<IntView>             order                 ();
        Stream<Stream<Node>>          components            ();
        Optional<IntView>             topological_order     ();
        Optional<IntSeq>              distances             ();


        int                           score                 (int uid);
        int                           rank                  (int uid);
        int                           pe                    (int uid);
        int                           pv                    (int uid);
        int                           tin                   (int uid);
        int                           low                   (int uid);
        boolean                       is_leader             (int uid);
        boolean                       is_reached            (int uid);
        boolean                       is_exited             (int uid);
        default boolean               is_follower           (int uid) { return !is_leader(uid); }

        static Replay of(Graph G, Memory mem, State ctx) {
            var gid = G.id();
            var order   = IntView.of(gon[gid], gon[gid] + ctx.rank(), (i) -> Memory.Storage.INSTANCE.buf[ Ω  ][i] );
            var leaders = IntView.of(gon[gid], gon[gid] + ctx.cid() , (j) -> Memory.Storage.INSTANCE.buf[ F  ][j] );
            return new Replay() {
                public boolean                  is_started              ()          { return ctx.is_started(); }
                public boolean                  reached_target          ()          { return ctx.is_stopped(); }
                public boolean                  is_stopped              ()          { return ctx.is_stopped(); }
                public boolean                  has_topological_order   ()          { return G.is_directed() && /* !is_cyclic() && */ is_vertex_connected(); }
                public boolean                  is_vertex_connected     ()          { return ctx.rank() == G.n();                                    } // what about when only '0's should be visited but "all" includes 1s,2s,...
                public Optional<Integer>        reached_count           ()          { return !is_started() ? Optional.empty() : Optional.of(ctx.rank()); }
                public Optional<Integer>        terminus                ()          { return !reached_target() ? Optional.empty() : Optional.of( ctx.uid() ); }
                public Optional<Integer>        dist                    ()          { return terminus().map(mem::score); }
                public Optional<IntView>        order                   ()          { return Optional.of(order);    }
                public Optional<IntView>        topological_order       ()          { return !has_topological_order() ? Optional.empty() : order(); }
                public Optional<IntSeq> distances() {
                    return Optional.of((downstream) -> {
                        G.nodes().forEach((node) -> {
                            downstream.push( mem.score( node.uid() ) );
                        });
                    });
                }
                public Stream<Stream<Node>>     components              ()          { return ConnectedComponents.of(G, order, leaders).stream().map(View::stream); }
                public int      score       (int uid)   { return mem.score(uid);      }
                public int      pe          (int uid)   { return mem.pe(uid);         }
                public int      pv          (int uid)   { return mem.pv(uid);         }
                public int      tin         (int uid)   { return mem.tin(uid);        }
                public int      low         (int uid)   { return mem.low(uid);        }
                public boolean  is_leader   (int uid)   { return mem.is_leader(uid);  }
                public boolean  is_reached  (int uid)   { return mem.is_reached(uid); }
                public boolean  is_exited   (int uid)   { return mem.is_exited(uid);  }
                public int      rank        (int uid)   { return G.n() - mem.rank(uid) - 1; }
            };
        }
    }

    interface Visitor {
        interface NC             { void     accept(int a); }
        interface EC             { void     accept(int a, int b, int c, int d, int e);     }
        interface NP             { boolean  test  (int a); }
        interface EP             { boolean  test  (int a, int b, int c, int d, int e); }

        default boolean     leader      (int uid, int alt)                          { return true; }
        default boolean     follower    (int it, int pe, int pv, int uid, int alt)  { return true; }
        default boolean     tree        (int it, int j, int uid, int vid, int alt)  { return true; }

        default void        enter       (int uid)                                   { }
        default void        exit        (int uid)                                   { }
        default void        dependency  (int it, int pe, int pv, int uid, int alt)  { }
        default void        parent      (int it, int j, int uid, int vid, int alt)  { }
        default void        back        (int it, int j, int uid, int vid, int alt)  { }
        default void        cross       (int it, int j, int uid, int vid, int alt)  { }
        default void        forward     (int it, int j, int uid, int vid, int alt)  { }
        default void        backtrack   (int it, int j, int uid, int vid, int alt)  { }

        class Builder {
            Seq<IIP> leader      = null;
            Seq<NC> exit        = null;
            Seq<EC> dependency  = null;
            Seq<EC> parent      = null;
            Seq<EC> back        = null;
            Seq<EC> cross       = null;
            Seq<EC> forward     = null;
            Seq<EC> backtrack   = null;
            Seq<EP> follower    = null;
            Seq<NC> enter       = null;
            Seq<EP> tree        = null;

            public Builder leader       (Seq<IIP> f)   { this.leader        = f; return this; }
            public Builder exit         (Seq<NC> f)    { this.exit          = f; return this; }
            public Builder dependency   (Seq<EC> f)    { this.dependency    = f; return this; }
            public Builder parent       (Seq<EC> f)    { this.parent        = f; return this; }
            public Builder back         (Seq<EC> f)    { this.back          = f; return this; }
            public Builder cross        (Seq<EC> f)    { this.cross         = f; return this; }
            public Builder forward      (Seq<EC> f)    { this.forward       = f; return this; }
            public Builder backtrack    (Seq<EC> f)    { this.backtrack     = f; return this; }
            public Builder follower     (Seq<EP> f)    { this.follower      = f; return this; }
            public Builder enter        (Seq<NC> f)    { this.enter         = f; return this; }
            public Builder tree         (Seq<EP> f)    { this.tree          = f; return this; }

            public Visitor build() {
                return new Visitor() {
                    @Override public void     exit        (int uid)                                              { if(exit      != null)   { exit      .forEach((nc) -> nc.accept(uid));         } }
                    @Override public void     dependency  (int it, int pe, int pv, int uid, int alt)             { if(dependency != null)  { dependency.forEach((ec) -> ec.accept(it, pe, pv, uid, alt)); } }
                    @Override public void     parent      (int it, int j, int uid, int vid, int alt)             { if(parent    != null)   { parent    .forEach((ec) -> ec.accept(it, j, uid, vid, alt)); } }
                    @Override public void     back        (int it, int j, int uid, int vid, int alt)             { if(back      != null)   { back      .forEach((ec) -> ec.accept(it, j, uid, vid, alt)); } }
                    @Override public void     cross       (int it, int j, int uid, int vid, int alt)             { if(cross     != null)   { cross     .forEach((ec) -> ec.accept(it, j, uid, vid, alt)); } }
                    @Override public void     forward     (int it, int j, int uid, int vid, int alt)             { if(forward   != null)   { forward   .forEach((ec) -> ec.accept(it, j, uid, vid, alt)); } }
                    @Override public void     backtrack   (int it, int j, int uid, int vid, int alt)             { if(backtrack != null)   { backtrack .forEach((ec) -> ec.accept(it, j, uid, vid, alt)); } }
                    @Override public boolean  leader      (int uid, int alt)                                     { if(leader    != null)   { leader    .forEach((iip) -> iip.test(uid, alt)); } return true; }
                    @Override public void     enter       (int uid)                                              { if(enter != null)       { enter     .forEach((nc) -> nc.accept(uid)); } }
                    @Override public boolean  follower    (int it, int pe, int pv, int uid, int alt) {
                        if(follower == null)
                            return true;
                        boolean[] all = { true };
                        follower.takeWhile((pipe) -> all[0] &= pipe.test(it, pe, pv, uid, alt));
                        return all[0];
                    }
                    @Override public boolean  tree        (int it, int j, int uid, int vid, int alt) {
                        if(tree == null) return true;
                        boolean[] all = { true };
                        tree.takeWhile((pipe) -> all[0] &= pipe.test(it, j, uid, vid, alt));
                        return all[0];
                    }
                };
            }
        }
        static Builder builder() {
            return new Visitor.Builder() {};
        }
    }
    interface HasVisitor { Visitor visitor(); }
    interface MaybeStateful<S> { Optional<S> state(); }

    interface Sized {
        int size();
        default boolean isEmpty() {
            return size() == 0;
        }
    }
    interface KeyedIterable<T> extends Sized, Iterable<T> {
        T getKey(int i);
        default Iterator<T> iterator() {
            return new Iterator<T>() {
                int it = 0;
                public boolean hasNext() { return it < size(); }
                public T next()          { return getKey( it++ ); }
            };
        }
        default Stream<T> stream() { return StreamSupport.stream(spliteratorUnknownSize(iterator(), ORDERED), false); }
        default void enumerate(IntObjConsumer<T> downstream) {
            var i = 0;
            for(var a: this) {
                downstream.accept(i++, a);
            }
        }
        default int count(Predicate<T> pred)                { return (int) stream().filter(pred::test).count(); }
        default Stream<T> peek(Consumer<T> consumer)        { return stream().peek(consumer::accept); }
        default Stream<T> filter(Predicate<T> pred)         { return stream().filter(pred::test); }
        default <R> Stream<R> map(Function<T, R> fn)        { return stream().map(fn::apply); }
        default boolean noneMatch(Predicate<T> predicate)   { return stream().noneMatch(predicate); }
        default boolean anyMatch(Predicate<T> predicate)    { return stream().anyMatch(predicate); }
        default boolean allMatch(Predicate<T> predicate)    { return stream().allMatch(predicate); }
        default IntStream mapToInt(ToIntFunction<T> fn)     { return stream().mapToInt(fn::applyAsInt); }
        default <R> R reduce(Function<T, R> fn, R id, BinaryOperator<R> op) { return reduce (fn, id, op, Function.identity()); }
        default int reduceToInt(ToIntFunction<T> fn, int id, IntBinaryOperator op) { return reduceToInt (fn, id, op, IntUnaryOperator.identity()); }
        default long reduceToLong(ToLongFunction<T> fn, long id, LongBinaryOperator op) { return reduceToLong(fn, id, op, LongUnaryOperator.identity()); }
        default <A, R> R reduce(Function<T, A> fn, A id, BinaryOperator<A> op, Function<A, R> fin) { return fin.apply(stream().map(fn).reduce(id, op)); }
        default int reduceToInt(ToIntFunction<T> fn, int id, IntBinaryOperator op, IntUnaryOperator fin) { return fin.applyAsInt(stream().mapToInt(fn).reduce(id, op)); }
        default long reduceToLong(ToLongFunction<T> fn, long id, LongBinaryOperator op, LongUnaryOperator fin) { return fin.applyAsLong(stream().mapToLong(fn).reduce(id, op)); }
    }
    interface View<T> extends KeyedIterable<T> {
        T get(int i);
        default T getKey(int i) {
            return get(i);
        }
        default     T           lpeek() { return get(0); }
        default     T           rpeek() { return get( size()-1 ); }
        default <R> View<R>     mapped(Function<T, R> fn)             { return    View.of(0, size(), (i) -> fn.apply(get(i))); }
        default     IntView     mappedToInt(ToIntFunction<T> mapper)  { return IntView.of(0, size(), (i) -> mapper.applyAsInt(get(i))); }
        static  <T> View<T>     of()                                  { return    View.of(0, 0                  , (__) -> null);                                         }
        static  <T> View<T>     of(View<T> A, T b)                    { return    View.of(0, A.size() + 1       , (i) -> i < A.size() ? A.get(i) : b                  ); }
        static  <T> View<T>     of(View<T> A, View<T> B)              { return    View.of(0, A.size() + B.size(), (i) -> i < A.size() ? A.get(i) : B.get( i-A.size() )); }
        static  <T> View<T>     of(int lo, int hi, IntFunction<T> ƒ) {
            return new View<>() {
                public int size()   { return sizi(lo, hi);    }
                public T get(int i) { return ƒ.apply( lo+i ); }
            };
        }
    }
    interface IntView extends KeyedIterable<Integer> {
        int get(int i);
        default Integer getKey(int i) { return get(i); }
        default int[] toArray()       { return range(0, size()).map(this::get).toArray(); }

        default IntView concated(int a)                      { return of(0, size()+1, i -> i == size() ? a : get(i)); }
        default IntView spliced(int lo, int hi)              { return of(lo, hi, IntView.this::get); }
        default IntView mapped(IntUnaryOperator fn)          { return of(0, size(), i -> fn.applyAsInt(get(i))); }
        default IntView filtered(IP predicate) {
            var ans = stream().filter(predicate::test).collect(Collectors.toList());
            return IntView.of(0, ans.size(), ans::get);
        }
        default IntBiSeq zipWith(IntUnaryOperator ƒ) {
            return (D) -> {
                this.forEach((uid) -> {
                    D.push(uid, ƒ.applyAsInt(uid));
                });
            };
        }

        static IntView of()                                  { return of(0, 0, __ -> NONE); }
        static IntView of(int a)                             { return of(0, 1, __ -> a); }
        static IntView of(int[] A)                           { return of(A, 0, A.length); }
        static IntView of(int[] A, int lo, int hi)           { return of(lo, hi, i -> A[i]); }
        static IntView of(int lo, int hi)                    { return of(lo, hi, IntUnaryOperator.identity()); }
        static IntView of(int lo, int hi, IntUnaryOperator fn) {
            return new IntView() {
                public int size()     { return sizi(lo, hi); }
                public int get(int i) { return fn.applyAsInt( lo+i ); }
            };
        }
        static IntView map    (IntView A, IntUnaryOperator ƒ) { return IntView.of(0 , A.size()    , (i) -> ƒ.applyAsInt( A.get(i) ));   }
        static IntView splice (IntView A, int lo, int hi)     { return IntView.of(lo, hi          , A::get);                            }
        static IntView rpush  (IntView A, int b)              { return IntView.of(0 , A.size()+1  , i -> i == A.size() ? b : A.get(i)); }
        static IntView reverse(IntView A)                     { return IntView.of(0 , A.size()    , i -> A.get( A.size()-i-1 ));        }
        static IntView head   (IntView A, int hi)             { return IntView.of(0 , hi          , A::get);                            }
        static IntView tail   (IntView A, int lo)             { return IntView.of(lo, A.size()    , A::get);                            }
    }
    interface LongView extends KeyedIterable<Long> {
        long get(int i);
        default Long getKey(int i) { return get(i); }

        static LongView of(int lo, int hi, IntToLongFunction f) {
            return new LongView() {
                public int size()       { return sizi(lo, hi); }
                public long get(int i)  { return f.applyAsLong( lo+i ); }
            };
        }
    }

    static final class StopException extends RuntimeException {
        static final StopException INSTANCE = new StopException();
        @Override public synchronized Throwable fillInStackTrace() {
            return this;
        }
    }
    static <T> T stop() {
        throw StopException.INSTANCE;
    }

    interface IntSeq {
        interface Downstream {
            void push(int a);
        }
        void forEach(Downstream ϴ);

        default IntSeq map    (IF f)                    { return (ϴ) -> forEach((a) -> ϴ.push( f.apply(a) )); }
        default LongSeq mapToLong(IntToLongFunction f)  { return (ϴ) -> forEach((a) -> ϴ.push( f.applyAsLong(a) )); }
        default IntSeq flatMap(IntFunction<IntSeq> f)   { return (ϴ) -> forEach((a) -> f.apply(a).forEach(ϴ::push)); }
        default IntSeq filter (IP P)                    { return (ϴ) -> forEach((a) -> { if(P.test(a)) { ϴ.push(a); } }); }
        default IntSeq peek   (IC before)               { return (ϴ) -> forEach((a) -> { before.accept(a); ϴ.push(a); }); }
        default int reduce(int id, IIF f) {
            int[] ans = { id };
            forEach((a) -> {
                ans[0] = f.apply(ans[0], a);
            });
            return ans[0];
        }

        default boolean forEachTillStop(Downstream ϴ) {
            try {
                forEach(ϴ);
                return true;
            } catch(Exception __) {
                return false;
            }
        };
        default IntBiSeq zipWithIndex() {
            int[] i = { 0 };
            return (ϴ) -> forEach((a) -> ϴ.push(a, i[0]++));
        }
        default IntBiSeq zipWith(IntUnaryOperator ƒ)    { return (ϴ) -> { forEach((a) -> { ϴ.push(a, ƒ.applyAsInt(a)); }); };  }
        default List<Integer> toList() {
            var list = new ArrayList<Integer>();
            forEach(list::add);
            return list;
        }
        default int[] toArray() {
            return toList().stream().mapToInt(Integer::intValue).toArray();
        }

        static     IntSeq of()                                                         { return (__) -> {}; }
        static     IntSeq of(int a)                                                    { return (ϴ) -> ϴ.push(a); }
        static     IntSeq of(IntSupplier S)                                            { return (ϴ) -> ϴ.push(S.getAsInt()); }
        static     IntSeq of(int[] A)                                                  { return (ϴ) -> Arrays.stream(A).forEach(ϴ::push); }
        static     IntSeq of(IntView A)                                                { return (ϴ) -> A.stream().forEach(ϴ::push); }
        static     IntSeq of(IntStream A)                                              { return (ϴ) -> A.forEach(ϴ::push); }
        static     IntSeq of(Stream<Integer> A)                                        { return (ϴ) -> A.forEach(ϴ::push); }
        static <T> IntSeq of(Supplier<View<T>> S, ToIntFunction<T> ƒ)                  { return (ϴ) -> S.get().mapToInt(ƒ).forEach(ϴ::push); }
        static <T> IntSeq of(Supplier<View<T>> S, ToIntFunction<T> ƒ, IP P)            { return (ϴ) -> S.get().mapToInt(ƒ).filter((a) -> P.test(a)).forEach(ϴ::push); }
        static <T> IntSeq unit(int a) { return (ϴ) -> ϴ.push(a); }
    }
    interface LongSeq {
        interface Downstream {
            void push(long a);
        }
        void forEach(Downstream downstream);

        default LongSeq map(LongUnaryOperator f) {
            return (ϴ) -> forEach((a) -> f.applyAsLong(a));
        }
        default long reduce(long id, LongBinaryOperator f) {
            long[] ans = { id };
            forEach((a) -> {
                ans[0] = f.applyAsLong(ans[0], a);
            });
            return ans[0];
        }
    }

    interface IntBiSeq {
        interface Downstream {
            void push(int a, int b);
        }
        void forEach(Downstream downstream);

        default IntBiSeq filter(IIP P) {
            return (downstream) -> {
                this.forEach((a, b) -> {
                    if(P.test(a, b)) {
                        downstream.push(a, b);
                    }
                });
            };
        }
        default IntSeq map(IIF f) {
            return (ϴ) -> forEach((a, b) -> ϴ.push( f.apply(a, b) ));
        }
        default LongSeq mapToLong(LongBinaryOperator f) {
            return (ϴ) -> forEach((a, b) -> ϴ.push( f.applyAsLong(a, b) ));
        }
        default IntBiSeq peek(IIC before) {
            return (ϴ) -> forEach((a, b) -> {
                before.accept(a, b);
                ϴ.push(a, b);
            });
        }
        default boolean forEachTillStop(Downstream ϴ) {
            try {
                forEach(ϴ);
                return true;
            } catch(Exception __) {
                return false;
            }
        };
    }
    interface IntTriSeq {
        interface Downstream {
            void push(int a, int b, int c);
        }

        void forEach(Downstream downstream);

        default IntTriSeq filter(IIIP P) {
            return (downstream) -> {
                forEach((a, b, c) -> {
                    if(P.test(a, b, c)) {
                        downstream.push(a, b, c);
                    }
                });
            };
        }
        default IntQuadSeq zipWithIndex() {
            return (downstream) -> {
                int[] i = { 0 };
                forEach((a, b, c) -> {
                    downstream.push(a, b, c, i[0]++);
                });
            };
        }
        default boolean forEachTillStop(Downstream downstream) {
            try {
                forEach(downstream);
                return true;
            } catch(Exception __) {
                return false;
            }
        }

        static IntTriSeq of(int[][] A) {
            Assert.that( A[0].length >= 3 );
            return (downstream) -> {
                for(var a: A) {
                    downstream.push(a[0], a[1], a[2]);
                }
            };
        }
    }
    interface IntQuadSeq {
        interface Downstream {
            void push(int a, int b, int c, int d);
        }
        void forEach(Downstream downstream);

        default IntQuadSeq filter(IIIIP P) {
            return (downstream) -> {
                forEach((a, b, c, d) -> {
                    if(P.test(a, b, c, d)) {
                        downstream.push(a, b, c, d);
                    }
                });
            };
        }
    }

    interface Seq<T> {
        interface Downstream<T> {
            void push(T a);
        }
        void forEach(Downstream<T> ϴ);
        default boolean forEachTillStop(Downstream<T> ϴ) {
            try {
                forEach(ϴ);
                return true;
            } catch(Exception __) {
                return false;
            }
        };
        default <R> Seq<R> map(Function<T, R> ƒ) {
            return (ϴ) -> {
                forEach((a) -> {
                    ϴ.push( ƒ.apply(a) );
                });
            };
        }
        default Seq<T> filter(Predicate<T> P) {
            return (ϴ) -> {
                forEach((a) -> {
                    if(P.test(a)) {
                        ϴ.push(a);
                    }
                });
            };
        }
        default Seq<T> takeWhile(Predicate<T> P) {
            return (D) -> {
                forEachTillStop((a) -> {
                    if(P.test(a)) {
                        D.push(a);
                    } else {
                        stop();
                    }
                });
            };
        }
        default Seq<T> rpush(T b) {
            return (ϴ) -> {
                forEach(ϴ);
                ϴ.push(b);
            };
        }
        default Seq<T> rpush(T[] B) {
            return (ϴ) -> {
                forEach(ϴ);
                stream(B).forEach(ϴ::push);
            };
        }
        default List<T> toList() {
            var ans = new ArrayList<T>();
            forEach(ans::add);
            return ans;
        }
        static <T> Seq<T> of()                   { return (ϴ) -> {};                         }
        static <T> Seq<T> of(T a)                { return (ϴ) -> ϴ.push(a);                  }
        static <T> Seq<T> of(T[] A)              { return (ϴ) -> stream(A).forEach(ϴ::push); }
        static <T> Seq<T> of(T a, T... B)        { return Seq.of(a).rpush(B);           }
    }

    interface IC                   { void      accept  (int a);                             }
    interface IIC                  { void      accept  (int a, int b);                      }
    interface IIIC                 { void      accept  (int a, int b, int c);               }
    interface IIIIC                { void      accept  (int a, int b, int c, int d);        }
    interface IIIIIC               { void      accept  (int a, int b, int c, int d, int e); }
    interface IP                   { boolean   test    (int a);                             }
    interface IIP                  { boolean   test    (int a, int b);                      }
    interface IIIP                 { boolean   test    (int a, int b, int c);               }
    interface IIIIP                { boolean   test    (int a, int b, int c, int d);        }
    interface IICP                 { boolean   test    (int a, int b, char c);              }
    interface IF                   { int       apply   (int a);                             }
    interface IIF                  { int       apply   (int a, int b);                      }
    interface IIIIF                { int       apply   (int a, int b, int c, int d);        }
    interface IntObjFunction<T, R> { R         apply   (int a, T   b);                      }
    interface IntObjConsumer<T>    { void      accept  (int a, T   b);                      }
    interface Fn2<A, B,             R>     { R apply(A a, B b); }
    interface Fn3 <A, B, C,         R>     { R apply(A a, B b, C c);                }
    interface Fn4<A, B, C, D,       R>     { R apply(A a, B b, C c, D d);           }
    interface Fn5<A, B, C, D, E,    R>     { R apply(A a, B b, C c, D d, E e);      }
    interface Fn6<A, B, C, D, E, F, R>     { R apply(A a, B b, C c, D d, E e, F f); }
    interface Fn7<A, B, C, D, E, F, G, R>  { R apply(A a, B b, C c, D d, E e, F f, G g); }

    static class Reader<R, A> {
        Function<R, A> run;
        Reader(Function<R, A> run) {
            this.run = run;
        }
        public A run(R env) {
            return run.apply(env);
        }
        <B>    Reader<R , B>  map     (Function<A, B> f)            { return Reader.of((r)  -> f.apply( this.run(r) )); }
        <B>    Reader<R , B>  flatMap (Function<A, Reader<R, B>> f) { return Reader.of((r)  -> f.apply( this.run(r) ).run( r )); }
        <E2>   Reader<E2, A>  local   (Function<E2, R> modifier)    { return Reader.of((e2) -> this.run( modifier.apply( e2 )) ); }
        static <R, A> Reader<R , A> pure     (A a)                      { return new Reader<>((__) -> a); }
        static <R, A> Reader<R , A> of       (Function<R, A> f)         { return new Reader<>(f); }
    }
    interface Effect<A> {
        A run();
    }
    /* record IO<A>(Effect<A> effect) {
        public A unsafeRun() {
            return effect.run();
        }
        <B> IO<B>    flatMap (Function<A, IO<B>> f)         { return IO.of(() -> f.apply( this.effect.run() ).unsafeRun()); }
        <B> IO<B>    map     (Function<A, B>     f)         { return this.flatMap((result) -> IO.of(() ->   f.apply(result)                 )); }
        IO<Void>     peek    (Consumer<A>        f)         { return this.flatMap((result) -> IO.of(() -> { f.accept(result); return null; })); }
        static <T> IO<T>  of  (Effect<T> effect)            { return new IO<>(effect); }
    }
     */

    static void IF(boolean condition, Runnable runnable) {
        if(condition) {
            runnable.run();
        }
    }
    static <T> void enumerate(T[] A, IntObjConsumer<T> downstream) {
        for(var i = 0; i < A.length; i++) {
            downstream.accept(i, A[i]);
        }
    }

    static int  INFI  = (int)  1e9;
    static long INFL = (long) (1E14 + 1);
    static int[] gon = new int[G];
    static int[] goe = new int[G];
    static int[] ilo = new int[N];
    static int[] olo = new int[N];
    static long[] src = new long[M];
    static long[] dst = new long[M];
    static int[] iref = new int[M];
    static int[] oref = new int[M];
    static AtomicInteger n_ptr = new AtomicInteger(0);
    static AtomicInteger m_ptr = new AtomicInteger(0);
    static AtomicInteger g_ptr = new AtomicInteger(0);
    static void reset(int n, int m) {
        if(g_ptr.get() == 0 || n_ptr.get() + (n+1) >= N || m_ptr.get() + (m+n) >= M) {
            reset();
        }
    }
    static void reset() {
        Arrays.fill( ilo, 0);
        Arrays.fill( olo, 0);
        n_ptr.set(0);
        m_ptr.set(0);
        g_ptr.set(0);
    }
    static double eps = 1E-6;
    static int      mini(int a, int b)                         { return Integer.min(a, b); }
    static int      maxi(int a, int b)                         { return Integer.max(a, b); }
    static int      signi(int a)                               { return Integer.signum(a); }
    static long     minl(long a, long b)                       { return Long.min(a, b); }
    static long     maxl(long a, long b)                       { return Long.max(a, b); }
    static double   maxd(double a, double b)                   { return Double.max(a, b); }
    static double   mind(double a, double b)                   { return Double.min(a, b); }
    static int      absi(int a)                                { return (int) Math.abs(a); }
    static double   absd(double a)                             { return Math.abs(a); }
    static int      sizi(int lo, int hi)                       { return hi - lo; }
    static int      nc2l(int n)                                { return n*(n-1) / 2; }
    static long     cdvl(long a, long b)                       { return (a+b-1) / b; }
    static int  mdisti(int y1, int x1, int y2, int x2)         { return Math.abs( y1-y2 ) + Math.abs( x1-x2 ); }
    static int[]   arri(int n, int a)                                   { return IntStream.generate(() -> a).limit(n).toArray(); }
    static int[]   arri(Collection<Integer> A)                          { return A.stream().mapToInt(Integer::intValue).toArray(); }
    static int[][] mati(Collection<? extends Collection<Integer>> A)    { return A.stream().map((row) -> arri(row)).toArray(int[][]::new); }
    static final int               maxi(int[]   A) { return Arrays.stream(A).max().getAsInt(); }
    static final Optional<Integer> maxi(int[][] A) { return Arrays.stream(A).map((a) -> maxi(a)).reduce(Integer::max); }
    static boolean  eqd(double a, double b) { return absd( a-b ) < eps; }
    static boolean  ltd(double a, double b) { return !eqd(a, b) && a < b; }
    static boolean  gtd(double a, double b) { return !eqd(a, b) && a > b; }
    static boolean  eqi(int a, int b) { return a == b; }
    static boolean  lti(int a, int b) { return a <  b; }
    static boolean  gti(int a, int b) { return a >  b; }
    static boolean ini(int a, int lo, int hi) { return lo <= a && a < hi; }
    static int bisi(int lo, int hi, IP predicate) {
        while(lo < hi) {
            var mi = lo + (hi-lo)/2;
            if(predicate.test(mi)) {
                lo = mi + 1;
            } else {
                hi = mi;
            }
        }
        return lo;
    }
    static int[][] str_to_dirs(String s)                                  { return s.chars().mapToObj(i->(char)i).map((c)->c=='U'?new int[]{-1,0}:c=='D'?new int[]{+1,0}:c=='L'?new int[]{0,-1} :new int[]{0,+1}).toArray(int[][]::new); }
    static boolean match(int y, int x, int ny, int nx, int di, int[][] dirs)  { return y + dirs[di][0] == ny && x + dirs[di][1] == nx; }

    static     Collector<CharSequence, ?, String > to1D  () { return Collectors.joining(",", "[", "]"); }
    static     Collector<CharSequence, ?, String > to2D  () { return Collectors.joining(",\n\t","[\n\t","\n]"); }
    static <T> Collector<T           , ?, View<T>> toView() { return Collector.of(View::of, View::of, View::of); }

    static String str(int[] A)  { return Arrays.stream(A).mapToObj((a) -> String.format("%3d", a)).collect(Collectors.joining(",","[","]")); }
    static String str(long[] A) { return Arrays.toString(A); }
    /*
        static String render(Object o) {
            if(o instanceof Number a)        { return String.format("%2d", a); }
            if(o instanceof IntView a)       { return a.stream().map(($) -> ""+$).collect(to1D()); }
            if(o instanceof View<?> a)       { return a.stream().map(($) -> ""+$.toString()).collect(to2D()); }
            throw new IllegalStateException("@ render");
        }
    */
    static class Assert {
        static void that(boolean condition) {
            if(!condition) {
                throw new AssertionError();
            }
        }
        static void that(boolean condition, String message) {
            if(!condition) {
                throw new AssertionError(message);
            }
        }
    }
    static <T> T[] arr(Class<T> clazz, IntFunction<T> initializer, int n) {
        var ans = (T[]) java.lang.reflect.Array.newInstance(clazz, n);
        Arrays.setAll(ans, initializer::apply);
        return ans;
    }
    static class IO extends PrintWriter {
        private InputStream stream;
        private byte[] buf = new byte[1 << 16];
        private int cur, cnt;

        IO() {
            this(System.in, System.out);
        }
        IO(InputStream i, OutputStream o) {
            super(o);
            stream = i;
        }
        IO(String i, String o) throws IOException {
            super(new FileWriter(o));
            stream = new FileInputStream(i);
        }
        private int nb() {
            if(cnt == -1)
                throw new InputMismatchException();
            if(cur >= cnt) {
                cur = 0;
                try {
                    cnt = stream.read(buf);
                } catch(IOException e) {
                    throw new InputMismatchException();
                }
                if(cnt <= 0)
                    return -1;  // end of file
            }
            return buf[cur++];
        }
        char nc() {
            int c = nb();
            while(is_spc(c))
                c = nb();
            return (char) c;
        }
        String ns() {
            int c = nb();
            while(is_spc(c))
                c = nb();
            var ans = new StringBuilder();
            do {
                if(is_vcp(c))
                    ans.appendCodePoint(c);
                c = nb();
            } while(!is_spc(c));
            return ans.toString();
        }
        char[] nsca() {
            return ns().toCharArray();
        }
        int[] nsia() {
            var s = ns();
            var n = s.length();
            var ans = new int[n];
            for(var i = 0; i < n; i++) {
                ans[i] = s.charAt(i)-'0';
            }
            return ans;
        }
        int[][] nsim(int n, int m) {
            var ans = new int[n][m];
            for(var y = 0; y < n; y++) {
                var s = ns();
                for(var x = 0; x < n; x++) {
                    ans[y][x] = s.charAt(x)-'0';
                }
            }
            return ans;
        }
        String nextLine0() {
            var ans = new StringBuilder();
            int c = nb();
            while(c != '\n' && c != -1) {
                if(c != '\r')
                    ans.appendCodePoint(c);
                c = nb();
            }
            return ans.toString();
        }
        String nextLine() {
            var s = nextLine0();
            while(s.trim().length() == 0) {
                s = nextLine0();
            }
            return s;
        }
        String nextLine(boolean ignore_empty_lines) {
            return ignore_empty_lines ? nextLine() : nextLine0();
        }
        int ni() {
            var c = nb();
            while(is_spc(c))
                c = nb();
            var sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = nb();
            }
            var ans = 0;
            do {
                if(c < '0' || c > '9')
                    throw new InputMismatchException();
                ans *= 10;
                ans += c-'0';
                c = nb();
            } while (!is_spc(c));
            return ans * sgn;
        }
        long nl() {
            long ans = 0;
            int c = nb();
            while( c <= ' ' )
                c = nb();
            var neg = (c == '-');
            if(neg)
                c = nb();
            do {
                ans = ans * 10 + c - '0';
            } while((c = nb()) >= '0' && c <= '9');
            return neg ? -ans : ans;
        }
        double nd() {
            int c = nb();
            while (is_spc(c))
                c = nb();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = nb();
            }
            double ans = 0;
            while(!is_spc(c) && c != '.') {
                if(c < '0' || c > '9')
                    throw new InputMismatchException();
                ans *= 10;
                ans += c - '0';
                c = nb();
            }
            if (c == '.') {
                c = nb();
                double m = 1;
                while (!is_spc(c)) {
                    if (c < '0' || c > '9')
                        throw new InputMismatchException();
                    m /= 10;
                    ans += (c - '0') * m;
                    c = nb();
                }
            }
            return ans * sgn;
        }

        int[]      nia(int n,         int o)    { return range(0, n).map(__ -> ni()+o).toArray(); }
        long[]      nla(int n,        long o)    { return range(0, n).mapToLong(__ -> nl()+o).toArray(); }
        int[][]    nim(int n, int m,  int[] o)  { return range(0, n).mapToObj(_y -> range(0, m).map(_x -> ni()+o[_x]).toArray()).toArray(int[][]::new); }
        long[][]    nlm(int n, int m, long[] o)  { return range(0, n).mapToObj(_y -> range(0, m).mapToLong(_x -> nl()+o[_x]).toArray()).toArray(long[][]::new); }
        char[][]    ncm(int n)                   { return range(0, n).mapToObj(_y -> ns().toCharArray()).toArray(char[][]::new); }
        String[]      nsa(int n)                   { return range(0, n).mapToObj(__ -> ns()).toArray(String[]::new); }
        String[][]    nsm(int n, int m)            { return range(0, n).mapToObj(_y -> range(0, m).mapToObj(_x -> ns()).toArray(String[]::new)).toArray(String[][]::new); }

        void println(    int[]   A, String c)                              { println( A == null ? -1 : STR.of(A, c) );      }
        void println(    int[][] A, String c)                              { println( A == null ? -1 : STR.of(A, c) );      }
        void println(   long[]   A, String c)                              { println( A == null ? -1 : STR.of(A, c) );      }
        void println(   long[][] A, String c)                              { println( A == null ? -1 : STR.of(A, c) );      }
        void println(   char[][] A)                                        { println( A == null ? -1 : STR.of(A)    );      }
        void println(   char[][] A, String c)                              { println( A == null ? -1 : STR.of(A, c) );      }
        void println( String[]   A, String c)                              { println( A == null ? -1 : STR.of(A, c) );      }
        void println( String[][] A, String c)                              { println( A == null ? -1 : STR.of(A, c) );      }
        void println(boolean[]   A, String c, String N, String Y)          { println( A == null ? -1 : STR.of(A, c, N, Y)); }

        void println(int[]  A, int o, String c)                     { println(ofsi(A, o), c); }

        private static boolean is_spc(int c)    { return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1; }
        private static boolean is_vcp(int c)    { return Character.isValidCodePoint(c); }
    }
    static class STR {
        static String of(    int[]    A, String cx)                        { return                      mkstr(A.length,                     x->       ""+A[x],            cx); }
        static String of(    int[]    A, int o, String cx)                 { return                      mkstr(A.length,                     x->       ""+(A[x]+o),        cx); }
        static String of(   long[]    A, String cx)                        { return                      mkstr(A.length,                     x->       ""+A[x],            cx); }
        static String of( String[]    A, String cx)                        { return                      mkstr(A.length,                     x->          A[x],            cx); }
        static String of(boolean[]    A, String cx, String N, String Y)    { return                      mkstr(A.length,                     x->          A[x] ? Y : N,    cx); }
        static String of(    int[][]  A, String cx)                        { return A.length == 0 ? "" : mkstr(A.length,     A[0].length, (y,x)->      ""+A[y][x],         cx); }
        static String of(   long[][]  A, String cx)                        { return A.length == 0 ? "" : mkstr(A.length,     A[0].length, (y,x)->      ""+A[y][x],         cx); }
        static String of( String[][]  A, String cx)                        { return A.length == 0 ? "" : mkstr(A.length,     A[0].length, (y,x)->      ""+A[y][x],         cx); }
        static String of(   char[][]  A)                                   { return                      mkstr(A.length,                   y   ->new String(A[y]),       "\n"); }
        static String of(   char[][]  A, String cx)                        { return A.length == 0 ? "" : mkstr(A.length,     A[0].length, (y,x)->      ""+A[y][x],         cx); }
        static String of(List<int[]>  A, String cx)                        { return                      mkstr(A.size(), A.get(0).length, (y,x) -> ""+A.get(y)[x],         cx);  }

        static String mkstr(int n, Function<Integer, String> map, String c)                   { return range(0, n).mapToObj(map::apply).collect(joining(c)); }
        static String mkstr(int n, int m, BiFunction<Integer, Integer, String> map, String c) { return range(0, n).mapToObj(y -> range(0, m).mapToObj(x -> map.apply(y, x)).collect(joining(c))).collect(joining("\n")); }
    }
    static  int[] ofsi(int[] A, int ofs)                               { return arri(A.length, z -> A[z]+ofs); }
    static  int[] arri(int n, IntUnaryOperator f) {
        var ans = new int[n];
        Arrays.setAll(ans, i -> f.applyAsInt(i));
        return ans;
    }
}